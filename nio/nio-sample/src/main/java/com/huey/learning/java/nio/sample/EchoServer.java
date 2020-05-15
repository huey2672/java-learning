package com.huey.learning.java.nio.sample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class EchoServer {

    public void start(int port) {
        try (
                // opens a selector
                Selector selector = Selector.open();

                // opens a server-socket channel
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            // binds the channel's socket to a local address
            // and configures the socket to listen for connections
            serverSocketChannel.bind(new InetSocketAddress(port));

            // adjusts the channel's mode to be non-blocking
            serverSocketChannel.configureBlocking(Boolean.FALSE);

            // registers the channel with the given selector, listening the ACCEPT event
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Echo server is started.");


            while (true) {
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

                    // if the key's channel is ready to accept a new socket connection
                    if (selectionKey.isAcceptable()) {
                        this.accept(selector, serverSocketChannel);
                    }

                    // if the key's channel is ready for reading
                    if (selectionKey.isReadable()) {
                        this.read(selector, selectionKey);
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param selector
     * @param serverSocketChannel
     * @throws IOException
     */
    private void accept(Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        // accepts a connection made to this channel's socket
        SocketChannel socketChannel = serverSocketChannel.accept();

        // adjusts the channel's mode to be non-blocking
        socketChannel.configureBlocking(Boolean.FALSE);

        // registers the channel with the given selector, listening the READ event
        socketChannel.register(selector, SelectionKey.OP_READ);

        //
        System.out.println(socketChannel.getRemoteAddress() + " connected.");
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

        StringBuilder requestMessageBuilder = new StringBuilder();
        int readLength;

        // reads the data from the client
        while ((readLength = socketChannel.read(byteBuffer)) > 0) {

            // changes the buffer's mode to be READ
            byteBuffer.flip();

            // reads the buffer's data
            requestMessageBuilder.append(Charset.defaultCharset().decode(byteBuffer));
        }

        // !
        if (readLength < 0) {
            selectionKey.cancel();
            System.out.printf("%s disconnected.\n", socketChannel.getRemoteAddress());
        } else {

            // registers the channel with the given selector, listening the READ event
            socketChannel.register(selector, SelectionKey.OP_READ);

            //
            String requestMessage = requestMessageBuilder.toString();
            System.out.printf("Received the data from %s: %s\n", socketChannel.getRemoteAddress(), requestMessage);

            // sends the data back to the client.
            socketChannel.write(Charset.defaultCharset().encode(requestMessage));
        }
    }

    public static void main(String[] args) {
        int port = Integer.valueOf(System.getProperty("server.port", "12345"));
        new EchoServer().start(port);
    }

}
