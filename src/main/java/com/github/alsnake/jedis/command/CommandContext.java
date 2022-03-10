package com.github.alsnake.jedis.command;

import java.util.List;

import com.github.alsnake.jedis.server.Reply;

public class CommandContext {
	private final List<String> args;
	private final Reply reply;

	public CommandContext(List<String> args, Reply reply) {
		this.args = args;
		this.reply = reply;
	}

	public List<String> getArgs() {
		return this.args;
	}

	public Reply getReply() {
		return this.reply;
	}
}
