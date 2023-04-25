package org.gencore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.gencore.config.ConfigImpl;
import org.gencore.config.GeneratorConfigImpl;
import org.gencore.events.GeneratorEvents;
import org.gencore.utils.ConfigUtils;

import java.io.File;

public class GenCore extends JavaPlugin {

    @Override
    public void onEnable() {
        long start = System.nanoTime();

        ConfigUtils utils = new ConfigUtils();
        Config config = new ConfigImpl();
        GeneratorConfig generatorConfig = new GeneratorConfigImpl();

        utils.check(new File(getDataFolder(), "config.yml"), "config.yml");
        utils.check(new File(getDataFolder(), "generators.yml"), "generators.yml");
        config.load();
        generatorConfig.load();

        Bukkit.getPluginManager().registerEvents(new GeneratorEvents(), this);
        long end = System.nanoTime();
        getLogger().info("Successfully loaded GenCore in " + (end - start) / 1000000 + "ms");
    }

    @Override
    public void onDisable() {

    }

    public static JavaPlugin getPlugin() {
        return GenCore.getPlugin(GenCore.class);
    }
}
