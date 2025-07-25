package dev.tonimatas.packetfixer.mixins.v1_20_5_fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
        if (isThisVersion()) {
            System.getProperties().setProperty("forge.disablePacketCompressionDebug", "true");
            System.out.println("Packet Fixer forge 1.20.5-1.21.5 has been applied successfully.");
        }
    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String s, String s1) {
        return isThisVersion();
    }
    
    private boolean isThisVersion() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("minecraft");

        if (modContainer.isPresent()) {
            String version = modContainer.get().getMetadata().getVersion().getFriendlyString();
            return version.equals("1.20.5") || version.equals("1.20.6") || version.equals("1.21") || version.equals("1.21.1") || version.equals("1.21.2") || version.equals("1.21.3") || version.equals("1.21.4") || version.equals("1.21.5") || version.equals("1.21.6");
        }

        return false;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return Collections.emptyList();
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
