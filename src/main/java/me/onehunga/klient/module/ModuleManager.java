package me.onehunga.klient.module;

import me.onehunga.klient.module.movement.Sprint;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

	List<ModuleBase> modules;

	public ModuleManager() {
		modules = new ArrayList<>();

		modules.add(new Sprint());
	}

	/**
	 * @param name name of the module
	 * @return returs true if the module was found
	 */
	public boolean toggle(String name) {
		for(ModuleBase module : modules) {
			if(module.name.equalsIgnoreCase(name)) {
				module.toggle();
				return true;
			}
		}
		return false;
	}

	public void onTick() {
		modules.forEach(it -> {
			if(it.enabled) it.onTick();
		});
	}
}
