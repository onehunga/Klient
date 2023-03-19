package me.onehunga.klient.command;

import me.onehunga.klient.utils.ChatUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

	private List<Command> commandList;

	public CommandManager() {
		commandList = new ArrayList<>();

		addCommands();
	}

	private void addCommands() {
		commandList.add(new CommandSay());
		commandList.add(new CommandToggle());
	}

	public boolean execute(@NotNull String command) {
		String raw = command.substring(1);
		String[] split = raw.split(" ");

		if(split.length == 0) return false;

		Command cmd = commandList.stream().filter(c -> c.match(split[0])).findFirst().orElse(null);
		if(cmd == null) {
			ChatUtils.send("command " + split[0] + " doesn't exist");
			return false;
		}
		try{
			String[] args = new String[split.length - 1];
			System.arraycopy(split, 1, args, 0, split.length - 1);

			cmd.execute(args);
		}
		catch(CommandException e) {
			ChatUtils.send("§c" + e.getMessage());
			return false;
		}
		return true;
	}
}
