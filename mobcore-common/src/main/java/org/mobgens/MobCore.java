package org.mobgens;

import org.apache.maven.model.Resource;
import org.bukkit.plugin.java.JavaPlugin;
import org.mobgens.config.ConfigImpl;
import org.mobgens.config.GeneratorConfigImpl;
import org.mobgens.utils.ConfigUtils;

import java.io.File;

public class MobCore extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigUtils.createConfigWithResource(new File(getDataFolder(), "config.yml"), "config.yml");
        ConfigUtils.createConfigWithResource(new File(getDataFolder(), "generators.yml"), "generators.yml");

        Config config = new ConfigImpl();
        config.load();

        GeneratorConfig generatorConfig = new GeneratorConfigImpl();
        generatorConfig.load();
    }

    @Override
    public void onDisable() {

    }

    public static JavaPlugin getPlugin() {
        return MobCore.getPlugin(MobCore.class);
    }
}
