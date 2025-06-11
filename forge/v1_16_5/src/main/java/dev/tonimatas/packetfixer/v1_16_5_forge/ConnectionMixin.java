package dev.tonimatas.packetfixer.v1_16_5_forge;

import dev.tonimatas.packetfixer.common.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.network.NetworkManager$1")
public class ConnectionMixin {
    @ModifyConstant(method = "initChannel", constant = @Constant(intValue = 30))
    private int timeout(int value) {
        return Config.getTimeout();
    }
}
