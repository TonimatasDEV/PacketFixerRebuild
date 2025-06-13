pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "PacketFixer"

include(":common")

include(":fabric:v1_18")
include(":fabric:v1_19")
include(":fabric:v1_19_3")
include(":fabric:v1_20_2")

include(":forge:v1_18")
include(":forge:v1_19")

include(":packetfixer")