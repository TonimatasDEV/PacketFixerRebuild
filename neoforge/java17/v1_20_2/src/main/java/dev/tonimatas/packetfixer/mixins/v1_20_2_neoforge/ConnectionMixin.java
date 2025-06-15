package dev.tonimatas.packetfixer.mixins.v1_20_2_neoforge;

import dev.tonimatas.packetfixer.common.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.network.Connection$1")
public class ConnectionMixin {
    @ModifyConstant(method = "initChannel", constant = @Constant(intValue = 30))
    private int timeout(int value) {
        return Config.getTimeout();
    }
}
