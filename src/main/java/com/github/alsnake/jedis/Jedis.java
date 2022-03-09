package com.github.alsnake.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jedis {
	private static final Logger LOGGER = LoggerFactory.getLogger(Jedis.class);

	public static void main(String[] args) {
		JedisServer jedisServer = new JedisServer("localhost", 6379);
		jedisServer.run();
		;
	}
}
