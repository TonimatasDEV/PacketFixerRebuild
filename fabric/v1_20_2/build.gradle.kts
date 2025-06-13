plugins {
    id("dev.tonimatas.packetfixer.fabric")
}

dependencies {
    implementation(project(":fabric:v1_18"))
    implementation(project(":fabric:v1_19"))
    implementation(project(":fabric:v1_19_3"))
}

loaderModPlugin {
    minecraftVersion = "1.20.4"
    javaVersion = JavaVersion.VERSION_17
    projects = listOf("v1_19_3")
}