pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "PacketFixer"

include(":common")

include(":fabric:java17:v1_18")
include(":fabric:java17:v1_19")
include(":fabric:java17:v1_19_3")
include(":fabric:java17:v1_20_2")

include(":forge:java17:v1_18")
include(":forge:java17:v1_19")

include(":packetfixer")