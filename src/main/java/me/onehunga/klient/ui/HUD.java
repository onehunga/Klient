package me.onehunga.klient.ui;

import me.onehunga.klient.Klient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class HUD {
	private static MinecraftClient mc = MinecraftClient.getInstance();

	public static void render(MatrixStack matrices) {
		renderArrayList(matrices);
	}

	private static void renderArrayList(MatrixStack matrices) {
		int index = 0;
		int width = mc.getWindow().getScaledWidth();
		var modules = Klient.INSTANCE.moduleManager.getEnabledModules();

		for(var mod : modules) {
			mc.textRenderer.drawWithShadow(matrices, mod.name, width - 4 - mc.textRenderer.getWidth(mod.name), 10 + (index * mc.textRenderer.fontHeight), -1);
			index++;
		}
	}
}
