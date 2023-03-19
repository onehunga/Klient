package me.onehunga.klient.module.movement;

import me.onehunga.klient.module.ModuleBase;
import me.onehunga.klient.module.ModuleCategory;

public class Sprint extends ModuleBase {

	public Sprint() {
		super(ModuleCategory.MOVEMENT, "Sprint", "keep sprinting", false);
	}

	@Override
	public void onTick() {
		if(mc.player.forwardSpeed > 0) {
			mc.player.setSprinting(true);
		}
	}
}
