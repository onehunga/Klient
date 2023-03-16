package me.onehunga.klient;

import me.onehunga.klient.command.CommandManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.api.ModInitializer;

public class Klient implements ModInitializer {

	public static Klient INSTANCE;
	public CommandManager commandManager;

	public Klient() {
		INSTANCE = this;

		commandManager = new CommandManager();
	}

	public Logger logger = LogManager.getLogger(Klient.class);

	@Override
	public void onInitialize() {
		logger.info("starting client");
	}
}