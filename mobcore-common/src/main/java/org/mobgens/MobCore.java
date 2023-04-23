package org.mobgens;

import org.bukkit.plugin.java.JavaPlugin;

public class MobCore extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static JavaPlugin getPlugin() {
        return MobCore.getPlugin(MobCore.class);
    }
}
