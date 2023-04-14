package me.onehunga.klient.ui.clickgui;

import me.onehunga.klient.Klient;
import me.onehunga.klient.module.ModuleBase;
import me.onehunga.klient.module.ModuleCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame {

	public ModuleCategory category;
	public int x, y, width, height, dragX, dragY;

	public boolean dragging;

	protected MinecraftClient mc;

	private List<Button> buttons;

	public Frame(ModuleCategory category, int x, int y, int width, int height) {
		this.category = category;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.dragging = false;
		this.mc = MinecraftClient.getInstance();

		this.buttons = new ArrayList<>();

		int offset = height;
		for(ModuleBase module : Klient.INSTANCE.moduleManager.getModulesByCategory(category)) {
			buttons.add(new Button(module, this, offset));
			offset += height;
		};
	}

	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		DrawableHelper.fill(matrices, x, y, x + width, y + height, -1);

		mc.textRenderer.draw(
				matrices,
				category.displayName,
				x + (width - mc.textRenderer.getWidth(category.displayName)) / 2,
				y + (height - mc.textRenderer.fontHeight) / 2,
				Color.BLACK.getRGB()
		);

		for(Button btn : buttons) {
			btn.render(matrices, mouseX, mouseY, delta);
		}
	}

	public void mouseClicked(double mouseX, double mouseY, int button) {
		if(isHovered(mouseX, mouseY) && button == 0) {
			dragging = true;
			dragX = (int)(mouseX - x);
			dragY = (int)(mouseY - y);
		}

		for(Button btn : buttons) {
			btn.mouseClicked(mouseX, mouseY, button);
		}
	}

	public void mouseReleased(double mouseX, double mouseY, int button) {
		if(button == 0 && dragging) {
			dragging = false;
		}
	}

	public boolean isHovered(double mouseX, double mouseY) {
		return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
	}

	public void updatePosition(double mouseX, double mouseY) {
		if(dragging) {
			x = (int)(mouseX - dragX);
			y = (int)(mouseY - dragY);
		}
	}
}
