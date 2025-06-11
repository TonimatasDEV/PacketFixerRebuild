package dev.tonimatas.packetfixer.v1_16_5_forge;

import dev.tonimatas.packetfixer.common.Config;
import dev.tonimatas.packetfixer.common.Messages;
import net.minecraft.network.login.server.SCustomPayloadLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SCustomPayloadLoginPacket.class)
public class ServerboundCustomQueryPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 1048576))
    private static int newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "read", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private static String newSize(String value) {
        return Messages.getPayloadMessage();
    }
}