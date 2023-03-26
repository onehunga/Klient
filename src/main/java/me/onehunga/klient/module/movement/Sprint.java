package me.onehunga.klient.module.movement;

import me.onehunga.klient.module.ModuleBase;
import me.onehunga.klient.module.ModuleCategory;
import org.lwjgl.glfw.GLFW;

public class Sprint extends ModuleBase {

	public Sprint() {
		super(ModuleCategory.MOVEMENT, "Sprint", "keep sprinting", GLFW.GLFW_KEY_UNKNOWN, false);
	}

	@Override
	public void onTick() {
		if(mc.player.forwardSpeed > 0) {
			mc.player.setSprinting(true);
		}
	}
}
