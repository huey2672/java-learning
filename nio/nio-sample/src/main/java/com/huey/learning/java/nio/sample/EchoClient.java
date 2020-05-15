package com.huey.learning.java.nio.sample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author huey
 */
public class EchoClient {

    public void start(String serverHost, int serverPort) {
        try (
                // opens a selector
                Selector selector = Selector.open();
                // opens a socket channel and connects it to a remote address
                SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(serverHost, serverPort));
                //
                Scanner scanner = new Scanner(System.in)) {

            System.out.printf("Connect to the server[%s:%s].\n", serverHost, serverPort);

            // adjusts the channel's mode to be non-blocking
            socketChannel.configureBlocking(Boolean.FALSE);

            // registers the channel with the given selector, listening the READ event
            socketChannel.register(selector, SelectionKey.OP_READ);

            // creates a thread to listen the messages from the server.
            new Thread(new ClinetHandler(selector)).start();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if ("quit".equalsIgnoreCase(line)) {
                    break;
                }

                // sends the data to the server.
                socketChannel.write(Charset.defaultCharset().encode(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClinetHandler implements Runnable {
        private Selector selector;

        public ClinetHandler(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                // tests if the selector is open
                while (selector.isOpen()) {

                    // tests if there is more than one available channel
                    if (selector.select() == 0) {
                        continue;
                    }

                    // gets the selector's selected-key set
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();

                    // iterates the the selected-key set
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {

                        // gets a key instance
                        SelectionKey selectionKey = (SelectionKey) iterator.next();
                        // removes the key from the selected-key set
                        iterator.remove();

                        //  if the key's channel is ready for reading
                        if (selectionKey.isReadable()) {
                            this.read(selector, selectionKey);
                        }

                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("The client handler is over.");
            }
        }

        /**
         * @param selector
         * @param selectionKey
         * @throws IOException
         */
        private void read(Selector selector, SelectionKey selectionKey) throws IOException {
            // gets the available channel for this key
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

            // allocates a new byte buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            StringBuilder responseMessageBuilder = new StringBuilder();
            int readLength;

            // reads the data from the server
            while ((readLength = socketChannel.read(byteBuffer)) > 0) {

                // changes the buffer's mode to be READ
                byteBuffer.flip();

                // reads the buffer's data
                responseMessageBuilder.append(Charset.defaultCharset().decode(byteBuffer));
            }

            // !
            if (readLength < 0) {
                selectionKey.cancel();
            }

            // registers the channel with the given selector, listening the READ event
            socketChannel.register(selector, SelectionKey.OP_READ);

            //
            String requestMessage = responseMessageBuilder.toString();
            System.out.println(requestMessage);
        }

    }

    public static void main(String[] args) {
        String serverHost = System.getProperty("server.host", "127.0.0.1");
        int serverPort = Integer.valueOf(System.getProperty("server.port", "12345"));
        new EchoClient().start(serverHost, serverPort);
    }
}
