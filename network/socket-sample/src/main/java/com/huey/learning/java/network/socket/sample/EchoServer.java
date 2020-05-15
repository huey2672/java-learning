package com.huey.learning.java.network.socket.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server, it receives lines from the clients, then echos them back to the clients.
 * 
 * @author huey
 */
public class EchoServer {

	/**
	 * Star the server
	 * 
	 * @param port
	 */
	public void start(int port) {
		try ( 
				// Creates a server socket, bound to the specified port.
				ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Echo server is started.");
			while (true) {
				// listens for a connection. The method blocks until a connection is made.
				Socket socket = serverSocket.accept();
				// creates a thread to handle the connection
				new Thread(new SocketHandler(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Socket handler, it read lines from a socket, then write them back to the
	 * socket.
	 * 
	 * @author huey
	 */
	public class SocketHandler implements Runnable {
		private Socket socket;

		public SocketHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try (
					// gets the input stream and the out stream of the socket
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter writer = new PrintWriter(socket.getOutputStream(), Boolean.TRUE)) {
				
				// reads the data from the client
				String inputLine;
				while ((inputLine = reader.readLine()) != null) {
					System.out.println(inputLine);
					// writes the data back to the client
					writer.println(inputLine);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// releases the resources
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		int port = Integer.valueOf(System.getProperty("server.port", "12345"));
		new EchoServer().start(port);
	}
}
