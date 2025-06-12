package dev.tonimatas.packetfixer.mixins.v1_19_forge;

import dev.tonimatas.packetfixer.common.Config;
import dev.tonimatas.packetfixer.common.Messages;
import net.minecraft.network.protocol.login.ServerboundCustomQueryPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerboundCustomQueryPacket.class)
public class ServerboundCustomQueryPacketMixin {
    @ModifyConstant(method = "lambda$new$0", constant = @Constant(intValue = 1048576))
    private static int newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "lambda$new$0", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private static String newSize(String value) {
        return Messages.getPayloadMessage();
    }
}