package me.onehunga.klient.module;

import me.onehunga.klient.module.settings.Setting;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleBase {
	public final ModuleCategory category;
	public final String name;
	public final String description;
	public int key;
	public boolean enabled;

	protected MinecraftClient mc;

	private List<Setting> settings;

	protected ModuleBase(ModuleCategory category, String name, String description, int key, boolean enabled) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.key = key;

		this.mc = MinecraftClient.getInstance();

		this.settings = new ArrayList<>();
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

	protected void addSettings(Setting... settings) {
		this.settings.addAll(Arrays.stream(settings).toList());
	}

	public List<Setting> getSettings() {
		return settings;
	}
}
