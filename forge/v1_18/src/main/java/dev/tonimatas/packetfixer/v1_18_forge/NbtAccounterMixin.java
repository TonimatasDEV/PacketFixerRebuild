package dev.tonimatas.packetfixer.v1_18_forge;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.nbt.NBTSizeTracker;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NBTSizeTracker.class)
public class NbtAccounterMixin {
    @Shadow @Final private long quota;

    @Redirect(method = "accountBits", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NBTSizeTracker;quota:J"))
    private long newSize$accountBytes(NBTSizeTracker instance) {
        return Config.isForceUnlimitedNbtEnabled() ? Config.getNbtMaxSize() : quota;
    }
}
