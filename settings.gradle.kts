pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.neoforged.net/releases")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "PacketFixer"

include(":common")

include(":fabric:java17:v1_18")
include(":fabric:java17:v1_19")
include(":fabric:java17:v1_19_3")
include(":fabric:java17:v1_20_2")

include(":forge:java17:v1_18")
include(":forge:java17:v1_19")
include(":forge:java17:v1_19_3")
include(":forge:java17:v1_19_4")
include(":forge:java17:v1_20_2")

include(":neoforge:java17:v1_20_2")

include(":packetfixer")
