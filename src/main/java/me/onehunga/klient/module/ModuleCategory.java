package me.onehunga.klient.module;

public enum ModuleCategory {
	MOVEMENT("Movement");

	public final String displayName;

	private ModuleCategory(String displayName) {
		this.displayName = displayName;
	}
}
