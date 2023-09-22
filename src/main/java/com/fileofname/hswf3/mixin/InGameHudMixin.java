package com.fileofname.hswf3.mixin;

import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	@Shadow
	private MinecraftClient client;

	@Inject(at = @At("HEAD"), method = "renderScoreboardSidebar", cancellable = true)
	private void hideScoreboard(CallbackInfo info) {
		if (client.getDebugHud().showDebugHud) info.cancel();
	}
}