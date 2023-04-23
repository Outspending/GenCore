package org.mobgens.utils;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.Resource;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mobgens.ConfigUtilities;
import org.mobgens.MobCore;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class ConfigUtils implements ConfigUtilities {

    @Override
    public @Nullable YamlConfiguration createConfigWithResource(File file, Resource resource) {
        JavaPlugin plugin = MobCore.getPlugin();
        plugin.saveResource("generators.yml", false);
        return YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public @Nullable YamlConfiguration getConfig(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public boolean check(File file, @NotNull Resource resource) {
        if (!file.exists()) {
            createConfigWithResource(file, resource);
            return false;
        }
        return true;
    }
}
