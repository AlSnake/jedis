package com.github.alsnake.jedis.commands;

import com.github.alsnake.jedis.command.CommandContext;
import com.github.alsnake.jedis.command.ICommand;
import com.github.alsnake.jedis.server.DataStore;
import com.github.alsnake.jedis.server.Encode;
import com.github.alsnake.jedis.server.Message;

public class SetCommand implements ICommand {
	@Override
	public void execute(CommandContext ctx) {
		if (ctx.getArgs().size() <= 1) {
			ctx.getReply().reply(Message.wrongArgumentCount(ctx.getCmd()), Encode.ERROR);
			return;
		}

		if (ctx.getArgs().size() > 2) {
			ctx.getReply().reply(Message.syntaxError(), Encode.ERROR);
			return;
		}

		String key = ctx.getArgs().get(0);
		String value = ctx.getArgs().get(1);
		DataStore.set(key, value);
		ctx.getReply().reply("OK", Encode.SIMPLE_STRING);
	}

	@Override
	public String getCommand() {
		return "set";
	}

	@Override
	public String getHelp() {
		return "Set key to hold the string value";
	}
}
