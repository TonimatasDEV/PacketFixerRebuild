package dev.tonimatas.packetfixer.fabric;

import dev.tonimatas.packetfixer.LoaderExtension;
import dev.tonimatas.packetfixer.LoaderPlugin;
import net.fabricmc.loom.LoomGradlePlugin;
import net.fabricmc.loom.api.LoomGradleExtensionAPI;
import org.gradle.api.Project;
import org.gradle.api.file.FileCollection;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.compile.JavaCompile;

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

            for (String projectStr : extension.getProjects()) {
                SourceSetContainer targetSourceSets = p.project(":fabric:java17:" + projectStr).getExtensions().getByType(SourceSetContainer.class);
                SourceSet targetMain = targetSourceSets.getByName("main");

                project.getTasks().named("compileJava", JavaCompile.class).configure(compileJava -> {
                    FileCollection extraSources = targetMain.getAllJava().getSourceDirectories();
                    compileJava.setSource(compileJava.getSource().plus(extraSources));
                });
            }
            
            project.getExtensions().configure(LoomGradleExtensionAPI.class, loom -> {
                project.getDependencies().add("mappings", loom.officialMojangMappings());
                String version = minecraftVersion.replaceAll("\\.", "_");
                loom.getMixin().add("main", "packetfixer.v" + version + ".fabric.refmap.json");
            });
            
            project.getExtensions().configure(JavaPluginExtension.class, java -> {
                java.setSourceCompatibility(extension.getJavaVersion());
                java.setTargetCompatibility(extension.getJavaVersion());
                java.withSourcesJar();
            });
        });
    }
}
