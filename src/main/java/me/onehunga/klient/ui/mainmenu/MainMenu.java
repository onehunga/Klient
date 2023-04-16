package me.onehunga.klient.ui.mainmenu;

import me.onehunga.klient.ui.altmanager.AltManager;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MainMenu extends Screen {

	private RotatingCubeMapRenderer background = new RotatingCubeMapRenderer(new CubeMapRenderer(new Identifier("textures/gui/title/background/panorama")));

	public MainMenu() {
		super(Text.empty());
	}

	@Override
	protected void init() {
		this.addDrawableChild(
			ButtonWidget.builder(Text.of("Singleplayer"), button -> this.client.setScreen(new SelectWorldScreen(this)))
			.dimensions(width / 2 - 100, height / 2 - 40, 200, 20)
			.build()
		);

		this.addDrawableChild(
			ButtonWidget.builder(Text.of("Multiplayer"), button -> this.client.setScreen(new MultiplayerScreen(this)))
			.dimensions(width / 2 - 100, height / 2 - 15, 200, 20)
			.build()
		);

		this.addDrawableChild(
			ButtonWidget.builder(Text.of("Alts"), button -> this.client.setScreen(new AltManager(this)))
			.dimensions(width / 2 - 100, height / 2 + 10, 200, 20)
			.build()
		);

		this.addDrawableChild(
			ButtonWidget.builder(Text.of("Settings"), button -> this.client.setScreen(new OptionsScreen(this, this.client.options)))
			.dimensions(width / 2 - 100, height / 2 + 35, 200, 20)
			.build()
		);

		this.addDrawableChild(
			ButtonWidget.builder(Text.of("Quit"), button -> this.client.scheduleStop())
			.dimensions(width - 100, height - 20, 100, 20)
			.build()
		);
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		background.render(delta * 100, 1);
		super.render(matrices, mouseX, mouseY, delta);
	}

}
