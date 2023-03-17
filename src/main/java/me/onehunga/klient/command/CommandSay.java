package me.onehunga.klient.command;

import net.minecraft.client.MinecraftClient;

public class CommandSay extends Command {

	public CommandSay() {
		super("say");
	}

	@Override
	public void execute(String[] args) throws CommandException {
		if(args.length == 0) {
			throw new CommandException("Usage: .say <message>");
		}

		String say = String.join(" ", args);

		MinecraftClient.getInstance().player.networkHandler.sendChatMessage(say);
	}
}
