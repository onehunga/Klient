package me.onehunga.klient.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ChatUtils {

	public static void send(final String s) {
		MinecraftClient.getInstance().player.sendMessage(Text.literal(s));
	}
}
