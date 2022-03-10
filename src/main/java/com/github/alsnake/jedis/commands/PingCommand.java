package com.github.alsnake.jedis.commands;

import com.github.alsnake.jedis.command.CommandContext;
import com.github.alsnake.jedis.command.ICommand;

public class PingCommand implements ICommand {
	@Override
	public void execute(CommandContext ctx) {
		System.out.println("PING EXECUTED WITH ARGS: " + ctx.getArgs());
	}

	@Override
	public String getCommand() {
		return "ping";
	}

	@Override
	public String getHelp() {
		return "Test Connection";
	}

}
