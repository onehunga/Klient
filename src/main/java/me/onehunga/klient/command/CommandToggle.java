package me.onehunga.klient.command;

import me.onehunga.klient.Klient;

public class CommandToggle extends Command {
	protected CommandToggle() {
		super("toggle", "t");
	}

	@Override
	public void execute(String[] args) throws CommandException {
		if(args.length != 1) {
			throw new CommandException("usage: .toggle <module name>");
		}

		if(!Klient.INSTANCE.moduleManager.toggle(args[0])) {
			throw new CommandException("toggle: module " + args[0] + " was not found");
		}
	}
}
