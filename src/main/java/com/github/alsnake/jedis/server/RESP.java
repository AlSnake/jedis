package com.github.alsnake.jedis.server;

public class RESP {
	public static String NullBulkString() {
		return "$-1\r\n";
	}
}
