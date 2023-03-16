package me.onehunga.klient.command;

import net.minecraft.client.MinecraftClient;

public class CommandSay extends Command {

	public CommandSay() {
		super("say");
	}

	@Override
	public boolean execute(String[] args) {
		if (args.length == 0) return true;

		String say = String.join(" ", args);

		MinecraftClient.getInstance().player.networkHandler.sendChatMessage(say);

		return true;
	}
}
