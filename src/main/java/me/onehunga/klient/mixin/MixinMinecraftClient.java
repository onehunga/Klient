package me.onehunga.klient.mixin;

import me.onehunga.klient.Klient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	void tick(CallbackInfo ci) {
		Klient.INSTANCE.onTick();
	}

}
