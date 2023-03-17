package me.onehunga.klient.command;

public abstract class Command {

	public final String name;

	protected Command(String name) {
		this.name = name;
	}

	public boolean match(String name) {
		return this.name.equalsIgnoreCase(name);
	}

	public abstract void execute(String[] args) throws CommandException;
}
