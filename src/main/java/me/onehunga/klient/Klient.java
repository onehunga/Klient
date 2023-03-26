package me.onehunga.klient;

import me.onehunga.klient.command.CommandManager;
import me.onehunga.klient.module.ModuleManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.api.ModInitializer;

public class Klient implements ModInitializer {

	public static Klient INSTANCE;
	public CommandManager commandManager;
	public ModuleManager moduleManager;

	public Klient() {
		INSTANCE = this;

		commandManager = new CommandManager();
		moduleManager = new ModuleManager();
	}

	public Logger logger = LogManager.getLogger(Klient.class);

	public void onTick() {
		moduleManager.onTick();
	}

	public void onKeyDown(int key) {
		moduleManager.onKey(key);
	}

	@Override
	public void onInitialize() {
		logger.info("starting client");
	}
}
