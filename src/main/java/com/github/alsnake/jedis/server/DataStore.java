package com.github.alsnake.jedis.server;

import java.util.HashMap;

public class DataStore {
	private static HashMap<String, String> data = new HashMap<>();

	public static void set(String key, String value) {
		data.put(key, value);
	}

	public static String get(String key) {
		return data.get(key);
	}
}
