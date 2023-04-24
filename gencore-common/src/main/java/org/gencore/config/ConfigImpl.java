package org.gencore.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;
import org.gencore.Config;
import org.gencore.GenCore;
import org.gencore.utils.ColorUtils;
import org.gencore.utils.ConfigUtils;

import java.io.File;
import java.util.logging.Level;

public class ConfigImpl implements Config {

    private static String prefix;
    private static String noPermission;

    @Override
    public void load() {
        JavaPlugin plugin = GenCore.getPlugin();
        YamlConfiguration config = ConfigUtils.check(new File(plugin.getDataFolder(), "config.yml"), "config.yml");

        /*
        * Loading the config
         */
        try {
            final String prefix = checkType(config.getString("prefix"));
            final String noPermission = checkType(config.getString("no-permission"));

            ConfigImpl.prefix = ColorUtils.colorizeHex(prefix);
            ConfigImpl.noPermission = ColorUtils.colorizeHex(noPermission);
        } catch (IllegalArgumentException e) {
            plugin.getLogger().severe("There was an issue loading config file!");
            return;
        }
        plugin.getLogger().log(Level.INFO, "Successfully loaded config file!");

    }

    @Override
    public <T> @Nullable T checkType(T type) throws IllegalArgumentException {
        if (type == null)
            throw new IllegalArgumentException();
        return type;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getNoPermission() {
        return noPermission;
    }
}
