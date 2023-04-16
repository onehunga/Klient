package me.onehunga.klient.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Session;

public class AccountUtils {
	
	public static void loginCracked(String username) {
		MinecraftClient.getInstance().session = new Session(username, username, username, null, null, null);
	}
}
