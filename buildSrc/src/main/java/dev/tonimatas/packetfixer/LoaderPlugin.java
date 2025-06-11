package dev.tonimatas.packetfixer;

import org.gradle.api.JavaVersion;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.BasePluginExtension;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.plugins.ide.idea.IdeaPlugin;

public class LoaderPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getPluginManager().apply(JavaPlugin.class);
        project.getPluginManager().apply(IdeaPlugin.class);

        project.getExtensions().configure(BasePluginExtension.class, java -> {
            java.getArchivesName().set("PacketFixer");
        });

        project.getExtensions().configure(JavaPluginExtension.class, java -> {
            java.setSourceCompatibility(JavaVersion.VERSION_1_8);
            java.setTargetCompatibility(JavaVersion.VERSION_1_8);
            java.withSourcesJar();
        });

        project.getTasks().withType(JavaCompile.class).configureEach(javaCompile -> javaCompile.getOptions().setEncoding("UTF-8"));
    }
}
