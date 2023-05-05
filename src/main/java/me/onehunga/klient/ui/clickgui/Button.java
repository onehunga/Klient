package me.onehunga.klient.ui.clickgui;

import me.onehunga.klient.module.ModuleBase;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.glfw.GLFW;

import java.awt.Color;

public class Button {

	private final ModuleBase module;
	private final Frame parent;
	private final int offset;

	private boolean renderSettings;
	private final Settings settings;

	public Button(ModuleBase module, Frame parent, int offset) {
		this.module = module;
		this.parent = parent;
		this.offset = offset;
		this.settings = new Settings(module.getSettings());
	}

	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		fill(matrices);
		if(isHovered(mouseX, mouseY)) fill(matrices);
		parent.mc.textRenderer.draw(
				matrices,
				module.name,
				parent.x + (float) (parent.width - parent.mc.textRenderer.getWidth(module.name)) / 2,
				parent.y + offset + (float) (parent.height - parent.mc.textRenderer.fontHeight) / 2,
				module.enabled ? new Color(255, 0, 0).getRGB() : -1
		);

		if(this.renderSettings) {
			settings.render(matrices, parent.x + parent.width, parent.y + offset);
		}
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
		if(isHovered(mouseX, mouseY) && button == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
			module.toggle();
		}
		else if(isHovered(mouseX, mouseY) && button == GLFW.GLFW_MOUSE_BUTTON_RIGHT) {
			this.renderSettings = !this.renderSettings;
		}
		this.settings.mouseClicked(mouseX, mouseY, button);
	}

	public boolean isHovered(double mouseX, double mouseY) {
		return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
	}
}
