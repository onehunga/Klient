package me.onehunga.klient.module.settings;

public class BoolSetting extends Setting {
	
	private boolean value;
	
	public BoolSetting(String name, boolean defaultValue) {
		super(name);
		this.value = defaultValue;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}