package me.onehunga.klient.ui.clickgui;

import me.onehunga.klient.Klient;
import me.onehunga.klient.module.settings.BoolSetting;
import me.onehunga.klient.module.settings.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.List;

/**
 * Settings is a list of values, that an module holds
 */
public class Settings {
	
	private static final int WIDTH = 100, HEIGHT = 20;

	private final MinecraftClient mc = MinecraftClient.getInstance();

	private int height = 0;
	
	private final List<Setting> settings;

	private int x, y;
	
	public Settings(List<Setting> settings) {
		this.settings = settings;

		this.height = settings.size() * HEIGHT;
	}
	
	public void render(MatrixStack matrices, int x, int y) {
		this.x = x;
		this.y = y;
		DrawableHelper.fill(matrices, x, y, x + WIDTH, y + height, new Color(0, 0, 0, 153).getRGB());

		int offset = 0;
		for(Setting setting : settings) {
			int settingsY = y + offset * HEIGHT;

			if(setting instanceof BoolSetting bs) {
				if(bs.getValue()) {
					DrawableHelper.fill(matrices, x + 5, settingsY + 5, x + 15, y + 15, -1);
				}
				else {
					DrawableHelper.drawBorder(matrices, x + 5, settingsY + 5, 10, 10, -1);
				}
				mc.textRenderer.draw(matrices, setting.name, x + 20, (y + offset * HEIGHT) + (float) (HEIGHT - mc.textRenderer.fontHeight) / 2, -1);
			}

			offset++;
		}
	}

	public void mouseClicked(double mouseX, double mouseY, int button) {
		if(mouseX >= x && mouseX <= x + WIDTH && mouseY >= y && mouseY <= y + height) {
			int component = (int) ((mouseY - y) / HEIGHT);
			Klient.INSTANCE.logger.info("Clicked Component number: " + component);

			if(settings.get(component) instanceof BoolSetting bs) {
				bs.setValue(!bs.getValue());
			}
		}
	}
}