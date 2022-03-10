package com.github.alsnake.jedis.commands;

import com.github.alsnake.jedis.command.CommandContext;
import com.github.alsnake.jedis.command.ICommand;
import com.github.alsnake.jedis.server.Encode;

public class PingCommand implements ICommand {
	@Override
	public void execute(CommandContext ctx) {
		if (ctx.getArgs().isEmpty()) {
			ctx.getReply().reply("PONG", Encode.SIMPLE_STRING);
			return;
		}
		ctx.getReply().reply(String.join(" ", ctx.getArgs()), Encode.BULK_STRING);
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
