import net.fabricmc.loom.task.RemapJarTask
import java.time.Instant
import java.time.format.DateTimeFormatter

plugins {
    java
    id("com.gradleup.shadow") version "9.0.0-beta15"
}

version = rootProject.version

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

dependencies {
}

tasks.register<Jar>("mergedJar") {
    archiveClassifier.set("merged")

    dependsOn("jar")
    dependsOn(":fabric:v1_16_5:remapJar", ":forge:v1_16_5:jar")

    val resourcesJar = tasks.named<Jar>("jar").get().archiveFile.get().asFile
    val commonJar = project(":common").tasks.named<Jar>("jar").get().archiveFile.get().asFile
    val fabricJar = project(":fabric:v1_16_5").tasks.named<RemapJarTask>("remapJar").get().archiveFile.get().asFile
    val forgeJar = project(":forge:v1_16_5").tasks.named<Jar>("jar").get().archiveFile.get().asFile

    manifest {
        attributes(
            "Specification-Title" to "Packet Fixer",
            "Specification-Vendor" to "TonimatasDEV",
            "Specification-Version" to version,
            "Implementation-Title" to "Packet Fixer",
            "Implementation-Version" to version,
            "Implementation-Vendor" to "TonimatasDEV",
            "Implementation-Timestamp" to DateTimeFormatter.ISO_INSTANT.format(Instant.now()),
            "MixinConfigs" to "packetfixer.v1_16_5.forge.mixins.json"
        )
    }
    
    from(zipTree(resourcesJar))
    from(zipTree(commonJar))
    from(zipTree(fabricJar))
    from(zipTree(forgeJar))

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}