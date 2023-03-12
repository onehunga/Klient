package me.onehunga.klient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.onehunga.klient.Klient;
import net.minecraft.client.gui.screen.ChatScreen;

@Mixin(ChatScreen.class)
public class MixinChatScreen {
	@Inject(method = "sendMessage", at = @At("HEAD"), cancellable = true)
	private void handleMessage(String message, boolean addToHistory, CallbackInfoReturnable<Boolean> ci) {
		if(message.startsWith(".")) {
			Klient.INSTANCE.logger.info(message);
			// we don't want to sent dot messages to the chat
			ci.cancel();
			ci.setReturnValue(true);
		}
	}
}
