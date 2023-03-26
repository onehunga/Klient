package me.onehunga.klient.module;

import net.minecraft.client.MinecraftClient;

public class ModuleBase {
	public final ModuleCategory category;
	public final String name;
	public final String description;
	public int key;
	public boolean enabled;

	protected MinecraftClient mc;

	protected ModuleBase(ModuleCategory category, String name, String description, int key, boolean enabled) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.key = key;

		this.mc = MinecraftClient.getInstance();
	}

	public void onEnable() {}

	public void onDisable() {}

	public void onTick() {}

	public void toggle() {
		enabled = !enabled;
		if(enabled) {
			onEnable();
		}
		else {
			onDisable();
		}
	}
}
