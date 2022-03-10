package com.github.alsnake.jedis.server;

public class Message {
	public static String unknownCommand(String cmd, String args) {
		return String.format("ERR Unknown or disabled command '%s' with args: '%s'", cmd,
				args);
	}

	public static String wrongArgumentCount(String cmd) {
		return String.format("ERR wrong number of arguments for '%s' command", cmd);
	}
}
