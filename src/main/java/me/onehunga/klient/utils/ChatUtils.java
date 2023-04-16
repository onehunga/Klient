package me.onehunga.klient.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ChatUtils {

	public static void send(final String s) {
		MinecraftClient mc = MinecraftClient.getInstance();
		mc.player.sendMessage(Text.of(s));
	}
}
