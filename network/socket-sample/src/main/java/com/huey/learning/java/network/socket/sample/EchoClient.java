package com.huey.learning.java.network.socket.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client, it reads lines from standard input and sends them to the server
 * 
 * @author huey
 */
public class EchoClient {

	/**
	 * Star the client
	 * 
	 * @param serverHost
	 * @param serverPort
	 */
	public void start(String serverHost, int serverPort) {
		try (
				// creates a socket and connects it to the specified port number on the named host
				Socket socket = new Socket(serverHost, serverPort);
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), Boolean.TRUE);
				Scanner scanner = new Scanner(System.in)) {

			// creates a thread to listen the messages from the server.
			new Thread(new SocketHandler(socket)).start();

			while (scanner.hasNextLine()) {
				// gets text from keyboard
				String line = scanner.nextLine();

				// sends the text to the server.
				writer.println(line);

				if ("quit".equalsIgnoreCase(line)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author huey
	 */
	public static class SocketHandler implements Runnable {
		private Socket socket;

		public SocketHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try (
					// gets the input stream from the socket
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

				String line = null;
				do {
					// reads the data from the input stream
					line = reader.readLine();
					System.out.println(line);
				} while (!"quit".equalsIgnoreCase(line));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String serverHost = System.getProperty("server.host", "127.0.0.1");
		int serverPort = Integer.valueOf(System.getProperty("server.port", "12345"));
		new EchoClient().start(serverHost, serverPort);
	}

}
