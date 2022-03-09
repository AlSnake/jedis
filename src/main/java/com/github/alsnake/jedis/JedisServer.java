package com.github.alsnake.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
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
				Socket client = serverSocket.accept();
				System.out.println("CONNECTED: " + client);
				client.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}
}
