package dev.tonimatas.packetfixer.mixins.v1_20_5_fabric;

import net.fabricmc.fabric.impl.networking.payload.PayloadHelper;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnstableApiUsage")
@Mixin(PayloadHelper.class)
public class PayloadHelperMixin {
    @Inject(method = "assertSize", at = @At("HEAD"), cancellable = true)
    private static void newSize$assertSize(FriendlyByteBuf buf, int maxSize, CallbackInfo ci) {
        ci.cancel();
    }
}
