package com.github.alsnake.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class JedisServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JedisServer.class);
	private ServerSocket serverSocket;
	private String host;
	private int port;

	public JedisServer(String host, int port) {
		this.host = host;
		this.port = port;

		try {
			serverSocket = new ServerSocket(port, 255, InetAddress.getByName((host)));
			serverSocket.setReuseAddress(true);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void run() {
		LOGGER.info("Jedis running on Port: " + port);

		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();
				// System.out.println("CONNECTED: " + clientSocket);

				String data = socketReadAll(clientSocket);
				Request request = RequestParser.parse(data);
				if (request.getCmd() != null) {
					System.out.println(request.getCmd());
				}

				clientSocket.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	private String socketReadAll(Socket socket) throws IOException {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while (input.ready() && (line = input.readLine()) != null)
			sb.append(line).append("\r\n");
		return sb.toString();
	}
}
