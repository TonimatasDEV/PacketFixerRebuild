package dev.tonimatas.packetfixer.forge;

import dev.tonimatas.packetfixer.LoaderExtension;
import org.gradle.internal.impldep.kotlinx.serialization.StringFormat;

public class ForgeExtension extends LoaderExtension {
    private String forgeVersion;

    public String getForgeVersion() {
        return forgeVersion;
    }

    public void setForgeVersion(String forgeVersion) {
        this.forgeVersion = forgeVersion;
    }
}
