package dev.tonimatas.packetfixer.mixins.v1_18_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.Varint21LengthFieldPrepender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = Varint21LengthFieldPrepender.class, priority = 1001)
public class Varint21LengthFieldPrependerMixin {
    @ModifyConstant(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V", constant = @Constant(intValue = 3))
    private int packetfixer$newSize(int value) {
        return Config.getVarInt21Size();
    }
}
