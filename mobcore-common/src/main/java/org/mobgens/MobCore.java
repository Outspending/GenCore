package org.mobgens;

import org.apache.maven.model.Resource;
import org.bukkit.plugin.java.JavaPlugin;
import org.mobgens.utils.ConfigUtils;

import java.io.File;

public class MobCore extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigUtils configUtils = new ConfigUtils();
        configUtils.createConfigWithResource(new File(getDataFolder(), "config.yml"), "config.yml");
    }

    @Override
    public void onDisable() {

    }

    public static JavaPlugin getPlugin() {
        return MobCore.getPlugin(MobCore.class);
    }
}
