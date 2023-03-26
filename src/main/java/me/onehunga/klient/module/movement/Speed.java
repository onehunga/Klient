package me.onehunga.klient.module.movement;

import me.onehunga.klient.module.ModuleBase;
import me.onehunga.klient.module.ModuleCategory;
import org.lwjgl.glfw.GLFW;

public class Speed extends ModuleBase {

	public Speed() {
		super(ModuleCategory.MOVEMENT, "Speed", "legit bhop", GLFW.GLFW_KEY_V, false);
	}

	@Override
	public void onTick() {
		if(mc.player.isOnGround()) {
			mc.player.jump();
		}
	}
}
