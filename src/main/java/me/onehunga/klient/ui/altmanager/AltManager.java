package me.onehunga.klient.ui.altmanager;

import org.lwjgl.glfw.GLFW;

import me.onehunga.klient.utils.AccountUtils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class AltManager extends Screen {
	
	private Screen parent;

	private TextFieldWidget usernameInput;

	public AltManager(Screen parent) {
		super(Text.empty());

		this.parent = parent;
	}

	@Override
	protected void init() {
		usernameInput = new TextFieldWidget(
			this.textRenderer,
			width / 2 - 100,
			height / 2,
			200,
			20,
			Text.of("username")
		);
		
		this.addDrawableChild(new TextWidget(width / 2 - 100, height / 2 - 20, 200, 20, Text.of("Username:"), this.textRenderer));
		this.addDrawableChild(usernameInput);

		this.addDrawableChild(
			ButtonWidget.builder(Text.of("Login"), btn -> {
				AccountUtils.loginCracked(usernameInput.getText());
			})
			.dimensions(width / 2 - 100, height / 2 + 25, 200, 20)
			.build()
		);
		
		this.addDrawableChild(
			ButtonWidget.builder(Text.of("Cancel"), button -> this.client.setScreen(this.parent))
			.dimensions(width - 100, height - 20, 100, 20)
			.build()
		);
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		if(keyCode == GLFW.GLFW_KEY_ESCAPE) {
			this.client.setScreen(parent);
			return true;
		}

		return super.keyPressed(keyCode, scanCode, modifiers);
	}
}
