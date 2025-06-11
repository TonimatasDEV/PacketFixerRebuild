package dev.tonimatas.packetfixer.v1_16_5_forge;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.play.server.SChunkDataPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SChunkDataPacket.class)
public class ClientboundLevelChunkPacketDataMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 2097152))
    private int init$size(int value) {
        return Config.getChunkPacketData();
    }
    
    @ModifyConstant(method = "read", constant = @Constant(stringValue = "Chunk Packet trying to allocate too much memory on read."))
    private String init$message(String constant) {
        return constant + " (" + Config.getChunkPacketData() + ") Modify it in the Packet Fixer config.";
    }
}
