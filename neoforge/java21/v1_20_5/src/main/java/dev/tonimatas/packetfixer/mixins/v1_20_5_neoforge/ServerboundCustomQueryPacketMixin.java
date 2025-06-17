package dev.tonimatas.packetfixer.mixins.v1_20_5_neoforge;

import dev.tonimatas.packetfixer.common.Config;
import dev.tonimatas.packetfixer.common.Messages;
import net.minecraft.network.protocol.login.ServerboundCustomQueryAnswerPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerboundCustomQueryAnswerPacket.class)
public class ServerboundCustomQueryPacketMixin {
    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 1048576))
    private static int newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private static String newSize(String value) {
        return Messages.getPayloadMessage();
    }
}