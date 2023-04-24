package org.gencore.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.gencore.GenCore;

import java.io.File;

public class ConfigUtils {

    public static YamlConfiguration createConfigWithResource(File file, String resourceName) {
        JavaPlugin plugin = GenCore.getPlugin();

        plugin.saveResource(resourceName, false);
        return YamlConfiguration.loadConfiguration(file);
    }

    public static YamlConfiguration getConfig(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    public static YamlConfiguration check(File file, String resourceName) {
        if (file.exists())
            return getConfig(file);

        return createConfigWithResource(file, resourceName);
    }

}
