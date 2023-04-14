package me.onehunga.klient.module;

public enum ModuleCategory {
	MOVEMENT("Movement"),
	RENDER("Render");

	public final String displayName;

	private ModuleCategory(String displayName) {
		this.displayName = displayName;
	}
}
