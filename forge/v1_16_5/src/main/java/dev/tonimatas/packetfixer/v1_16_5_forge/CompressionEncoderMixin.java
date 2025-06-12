package dev.tonimatas.packetfixer.v1_16_5_forge;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.NettyCompressionEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(NettyCompressionEncoder.class)
public class CompressionEncoderMixin {
    @ModifyConstant(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V", constant = @Constant(intValue = 2097152))
    private int newSize(int value) {
        return Config.getDecoderSize();
    }
}
