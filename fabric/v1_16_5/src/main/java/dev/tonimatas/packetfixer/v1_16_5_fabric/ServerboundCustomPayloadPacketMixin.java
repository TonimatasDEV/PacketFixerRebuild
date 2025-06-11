package dev.tonimatas.packetfixer.v1_16_5_fabric;

import dev.tonimatas.packetfixer.common.Config;
import dev.tonimatas.packetfixer.common.Messages;
import net.minecraft.network.protocol.game.ServerboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerboundCustomPayloadPacket.class)
public class ServerboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 32767))
    private int newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "read", constant = @Constant(stringValue = "Payload may not be larger than 32767 bytes"))
    private String newSize(String value) {
        return Messages.getPayloadMessage();
    }
}
