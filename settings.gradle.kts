pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "PacketFixer"

include(":common")
include(":fabric:v1_16_5")
include(":forge:v1_16_5")
include(":packetfixer")