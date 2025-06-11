package dev.tonimatas.packetfixer.v1_16_5_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.nbt.NbtAccounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NbtAccounter.class)
public class NbtAccounterMixin {
    @Shadow @Final private long quota;

    @Redirect(method = "accountBits", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J"))
    private long newSize$accountBytes(NbtAccounter instance) {
        return Config.getNbtMaxSize() < quota ? quota : Config.getNbtMaxSize();
    }
}
