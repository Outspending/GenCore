package org.mobgens;

import org.bukkit.plugin.java.JavaPlugin;
import org.mobgens.registry.GeneratorRegistry;
import org.mobgens.storage.MobDatabase;

public class MobCore extends JavaPlugin {

    @Override
    public void onEnable() {
        MobDatabase database = new MobDatabase();
        database.checkDatabase();

        new GeneratorRegistry().registerAllGenerators();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
