package org.mobgens.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mobgens.MobCore;
import org.mobgens.api.GeneratorConfiguration;
import org.mobgens.api.YamlHandler;

import java.io.File;

public class YamlUtils implements YamlHandler {

    private Plugin plugin = MobCore.getPlugin(MobCore.class);

    @Override
    public @Nullable FileConfiguration loadFile(@NotNull String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                plugin.saveResource(path, false);
                file.createNewFile();
                return YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "\\" + path));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public @NotNull GeneratorConfiguration loadGenerator(FileConfiguration configuration, @NotNull String path) {
        return GeneratorConfiguration.load(configuration, path);
    }
}
