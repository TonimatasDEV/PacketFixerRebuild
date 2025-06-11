package dev.tonimatas.packetfixer;

import org.gradle.api.JavaVersion;

public class LoaderExtension {
    private String minecraftVersion;

    public String getMinecraftVersion() {
        return minecraftVersion;
    }

    public void setMinecraftVersion(String minecraftVersion) {
        this.minecraftVersion = minecraftVersion;
    }
}
