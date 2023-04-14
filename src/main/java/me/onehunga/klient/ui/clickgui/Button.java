package me.onehunga.klient.ui.clickgui;

import me.onehunga.klient.module.ModuleBase;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import java.awt.Color;

public class Button {

	private ModuleBase module;
	private Frame parent;
	private int offset;

	public Button(ModuleBase module, Frame parent, int offset) {
		this.module = module;
		this.parent = parent;
		this.offset = offset;
	}

	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		fill(matrices);
		if(isHovered(mouseX, mouseY)) fill(matrices);
		parent.mc.textRenderer.draw(
				matrices,
				module.name,
				parent.x + (parent.width - parent.mc.textRenderer.getWidth(module.name)) / 2,
				parent.y + offset + (parent.height - parent.mc.textRenderer.fontHeight) / 2,
				module.enabled ? new Color(255, 0, 0).getRGB() : -1
		);
	}

	private void fill(MatrixStack matrices) {
		DrawableHelper.fill(
				matrices,
				parent.x + 5,
				parent.y + offset,
				parent.x + parent.width - 5,
				parent.y + offset + parent.height,
				new Color(0, 0, 0, 153).getRGB()
		);
	}

	public void mouseClicked(double mouseX, double mouseY, int button) {
		if(isHovered(mouseX, mouseY) && button == 0) {
			module.toggle();
		}
	}

	public boolean isHovered(double mouseX, double mouseY) {
		return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
	}
}
