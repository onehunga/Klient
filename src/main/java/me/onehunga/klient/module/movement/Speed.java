package me.onehunga.klient.module.movement;

import me.onehunga.klient.module.ModuleBase;
import me.onehunga.klient.module.ModuleCategory;
import me.onehunga.klient.module.settings.BoolSetting;
import org.lwjgl.glfw.GLFW;

public class Speed extends ModuleBase {

	BoolSetting autoSprint;

	public Speed() {
		super(ModuleCategory.MOVEMENT, "Speed", "legit bhop", GLFW.GLFW_KEY_V, false);

		this.autoSprint = new BoolSetting("Auto Sprint", false);

		addSettings(this.autoSprint);
	}

	@Override
	public void onTick() {
		if(mc.player.forwardSpeed > 0) {
			if(this.autoSprint.getValue()) {
				mc.player.setSprinting(true);
			}
			if(mc.player.isOnGround()) {
				mc.player.jump();
			}
		}
	}
}
