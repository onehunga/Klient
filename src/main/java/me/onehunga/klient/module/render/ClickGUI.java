package me.onehunga.klient.module.render;

import me.onehunga.klient.module.ModuleBase;
import me.onehunga.klient.module.ModuleCategory;
import org.lwjgl.glfw.GLFW;

public class ClickGUI extends ModuleBase {
	public ClickGUI() {
		super(ModuleCategory.RENDER, "ClickGUI", "ClickGUI", GLFW.GLFW_KEY_RIGHT_SHIFT, false);
	}

	@Override
	public void toggle() {
		// super.toggle();
		mc.setScreen(me.onehunga.klient.ui.clickgui.ClickGUI.INSTANCE);
	}
}
