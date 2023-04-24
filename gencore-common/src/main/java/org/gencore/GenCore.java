package org.gencore;

import org.bukkit.plugin.java.JavaPlugin;
import org.gencore.config.ConfigImpl;
import org.gencore.config.GeneratorConfigImpl;
import org.gencore.utils.ConfigUtils;

import java.io.File;

public class GenCore extends JavaPlugin {

    @Override
    public void onEnable() {
        long start = System.nanoTime();
        ConfigUtils.check(new File(getDataFolder(), "config.yml"), "config.yml");
        ConfigUtils.check(new File(getDataFolder(), "generators.yml"), "generators.yml");

        Config config = new ConfigImpl();
        config.load();

        GeneratorConfig generatorConfig = new GeneratorConfigImpl();
        generatorConfig.load();

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
