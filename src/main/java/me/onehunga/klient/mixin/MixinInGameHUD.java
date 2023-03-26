package me.onehunga.klient.mixin;

import me.onehunga.klient.ui.HUD;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHUD {

	@Inject(method = "render", at = @At("RETURN"), cancellable = true)
	void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
		HUD.render(matrices);
	}
}
