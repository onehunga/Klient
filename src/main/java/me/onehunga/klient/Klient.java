package me.onehunga.klient;

import me.onehunga.klient.command.CommandManager;
import me.onehunga.klient.module.ModuleManager;
import me.onehunga.klient.ui.clickgui.ClickGUI;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.api.ModInitializer;
import org.lwjgl.glfw.GLFW;

public class Klient implements ModInitializer {

	public static Klient INSTANCE;
	public CommandManager commandManager;
	public ModuleManager moduleManager;

	private MinecraftClient mc;

	public Klient() {
		INSTANCE = this;

		commandManager = new CommandManager();
		moduleManager = new ModuleManager();

		mc = MinecraftClient.getInstance();
	}

	public Logger logger = LogManager.getLogger(Klient.class);

	public void onTick() {
		if(mc.player != null) {
			moduleManager.onTick();
		}
	}

	public void onKeyDown(int key) {
		if(key == GLFW.GLFW_KEY_RIGHT_SHIFT) {
			MinecraftClient.getInstance().setScreen(ClickGUI.INSTANCE);
		}
		moduleManager.onKey(key);
	}

	@Override
	public void onInitialize() {
		logger.info("starting client");
	}
}
