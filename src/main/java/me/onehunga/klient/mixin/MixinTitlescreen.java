package me.onehunga.klient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.onehunga.klient.ui.mainmenu.MainMenu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;

@Mixin(TitleScreen.class)
public class MixinTitlescreen {
	@Inject(method = "init", at = @At("HEAD"))
	void init(CallbackInfo ci) {
		MinecraftClient.getInstance().setScreen(new MainMenu());
	}
}
