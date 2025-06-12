package dev.tonimatas.packetfixer.fabric;

import dev.tonimatas.packetfixer.LoaderExtension;
import dev.tonimatas.packetfixer.LoaderPlugin;
import net.fabricmc.loom.LoomGradlePlugin;
import net.fabricmc.loom.api.LoomGradleExtensionAPI;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;

@SuppressWarnings({"unused", "UnstableApiUsage"})
public class FabricModPlugin extends LoaderPlugin {
    @Override
    public void apply(Project project) {
        super.apply(project);
        LoaderExtension extension= project.getExtensions().create("loaderModPlugin", LoaderExtension.class);
        
        String loaderVersion = (String) project.getRootProject().findProperty("loaderVersion");
        
        project.afterEvaluate(p -> {
            project.getPluginManager().apply(LoomGradlePlugin.class);

            String minecraftVersion = extension.getMinecraftVersion();
            
            project.setVersion(project.getRootProject().getVersion() + "-fabric-" + extension.getMinecraftVersion());

            project.getDependencies().add("implementation", project.project(":common"));
            project.getDependencies().add("minecraft", "com.mojang:minecraft:" + minecraftVersion);
            project.getDependencies().add("modImplementation", "net.fabricmc:fabric-loader:" + loaderVersion);
            
            project.getExtensions().configure(LoomGradleExtensionAPI.class, mixin -> {
                project.getDependencies().add("mappings", mixin.officialMojangMappings());
                String version = minecraftVersion.replaceAll("\\.", "_");
                mixin.getMixin().add("main", "packetfixer.v" + version + ".fabric.refmap.json");
            });

            project.getExtensions().configure(JavaPluginExtension.class, java -> {
                java.setSourceCompatibility(extension.getJavaVersion());
                java.setTargetCompatibility(extension.getJavaVersion());
                java.withSourcesJar();
            });
        });
    }
}
