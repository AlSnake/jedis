package com.github.alsnake.jedis.commands;

import com.github.alsnake.jedis.command.CommandContext;
import com.github.alsnake.jedis.command.ICommand;
import com.github.alsnake.jedis.server.DataStore;
import com.github.alsnake.jedis.server.Encode;
import com.github.alsnake.jedis.server.Message;
import com.github.alsnake.jedis.server.RESP;

public class GetCommand implements ICommand {
	@Override
	public void execute(CommandContext ctx) {
		if (ctx.getArgs().size() != 1) {
			ctx.getReply().reply(Message.wrongArgumentCount(ctx.getCmd()), Encode.ERROR);
			return;
		}

		String key = ctx.getArgs().get(0);
		String value = DataStore.get(key);

		if (value == null) {
			ctx.getReply().reply(RESP.NullBulkString(), Encode.NONE);
			return;
		}

		ctx.getReply().reply(value, Encode.BULK_STRING);
	}

	@Override
	public String getCommand() {
		return "get";
	}

	@Override
	public String getHelp() {
		return "Get the value of key";
	}
}
