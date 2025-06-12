plugins {
    id("dev.tonimatas.packetfixer.fabric")
}

dependencies {
    implementation(project(":fabric:v1_18"))
}

loaderModPlugin {
    minecraftVersion = "1.19.2"
    javaVersion = JavaVersion.VERSION_17
}