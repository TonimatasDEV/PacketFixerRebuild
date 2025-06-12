package dev.tonimatas.packetfixer.v1_18_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.CompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CompressionDecoder.class)
public class CompressionDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 8388608))
    private int newSize(int value) {
        return Config.getDecoderSize();
    }
}