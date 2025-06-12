plugins {
    id("dev.tonimatas.packetfixer.forge")
}

dependencies {
    implementation(project(":forge:v1_18"))
}

loaderModPlugin {
    minecraftVersion = "1.19.2"
    forgeVersion = "43.5.0"
    javaVersion = JavaVersion.VERSION_17
}
