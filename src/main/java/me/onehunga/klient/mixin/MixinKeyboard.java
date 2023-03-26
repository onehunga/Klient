package me.onehunga.klient.mixin;

import me.onehunga.klient.Klient;
import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {

	@Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
	void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
		if(action == GLFW.GLFW_PRESS) {
			Klient.INSTANCE.onKeyDown(key);
		}
	}
}
