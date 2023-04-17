package org.mobgens.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mobgens.MobCore;
import org.mobgens.api.GeneratorConfiguration;

import java.io.File;

public class YamlUtils {

    public static @Nullable FileConfiguration loadFile(@NotNull String path) {
        Plugin plugin = MobCore.getPlugin();
        File file = new File(plugin.getDataFolder(), path);
        if (!file.exists()) {
            try {
                plugin.saveResource(path, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public static @NotNull GeneratorConfiguration loadGenerator(FileConfiguration configuration, @NotNull String path) {
        return GeneratorConfiguration.load(configuration, path);
    }
}
