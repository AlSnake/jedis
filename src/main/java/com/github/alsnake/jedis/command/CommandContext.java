package com.github.alsnake.jedis.command;

import java.util.List;

public class CommandContext {
	private final List<String> args;

	public CommandContext(List<String> args) {
		this.args = args;
	}

	public List<String> getArgs() {
		return this.args;
	}
}
