pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "PacketFixer"

include(":common")
include(":fabric:v1_16_5")
include(":forge:v1_16_5")
include(":fabric:v1_18")
include(":forge:v1_18")
include(":fabric:v1_19")
include(":forge:v1_19")
include(":packetfixer")