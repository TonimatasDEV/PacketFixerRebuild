package dev.tonimatas.packetfixer.v1_18_forge;

import dev.tonimatas.packetfixer.common.Config;
import dev.tonimatas.packetfixer.common.Messages;
import net.minecraft.network.play.client.CCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CCustomPayloadPacket.class)
public class ClientboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 32767))
    private int packet$newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "read", constant = @Constant(stringValue = "Payload may not be larger than 32767 bytes"))
    private String packet$newMessage(String value) {
        return Messages.getPayloadMessage();
    }
}
