package com.github.alsnake.jedis;

import java.util.ArrayList;

public class Request {
	private String cmd;
	private ArrayList<String> args;

	public Request(String cmd, ArrayList<String> args) {
		this.cmd = cmd;
		this.args = args;
	}

	public String getCmd() {
		return this.cmd;
	}

	public ArrayList<String> getArgs() {
		return this.args;
	}
}
