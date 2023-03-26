package me.onehunga.klient.command;

public abstract class Command {

	public final String name;
	public final String[] aliases;

	protected Command(String name, String... aliases) {
		this.name = name;
		this.aliases = aliases;
	}

	public boolean match(String name) {
		if(this.name.equalsIgnoreCase(name)) return true;
		for(String it : aliases) {
			if(it.equalsIgnoreCase(name)) return true;
		}
		return false;
	}

	public abstract void execute(String[] args) throws CommandException;
}
