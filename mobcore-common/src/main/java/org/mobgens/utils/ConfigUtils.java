package org.mobgens.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.mobgens.MobCore;

import java.io.File;

public class ConfigUtils {

    public static YamlConfiguration createConfigWithResource(File file, String resourceName) {
        JavaPlugin plugin = MobCore.getPlugin();

        plugin.saveResource(resourceName, false);
        return YamlConfiguration.loadConfiguration(file);
    }

    public static YamlConfiguration getConfig(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    public static boolean check(File file, String resourceName) {
        if (file.exists())
            return true;

        createConfigWithResource(file, resourceName);
        return false;
    }

}
