package org.mobgens.registry;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.mobgens.MobCore;
import org.mobgens.api.Generator;
import org.mobgens.api.GeneratorConfiguration;
import org.mobgens.api.RegistryHandler;
import org.mobgens.utils.YamlUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class GeneratorRegistry implements RegistryHandler {

    public static Map<String, Generator> registeredGenerators = new HashMap<>();
    private static final Plugin plugin = MobCore.getPlugin(MobCore.class);
    private static final YamlUtils utils = new YamlUtils();
    private static final FileConfiguration configuration = utils.loadFile(plugin.getDataFolder().getAbsolutePath() + "/generators.yml");

    @Override
    public void registerAllGenerators() {
        for (String key : GeneratorConfiguration.getGeneratorList())
            registerGenerator(key);
    }

    @Override
    public void registerGenerator(@NotNull String name) {
        GeneratorConfiguration config = GeneratorConfiguration.load(configuration, name);
        registeredGenerators.put(name, config.getGenerator());
        plugin.getLogger().log(Level.INFO, "Registered generator: " + name);
    }

    @Override
    public void unregisterGenerator(@NotNull String name) {
        if (!registeredGenerators.containsKey(name))
            return;

        registeredGenerators.remove(name);
        plugin.getLogger().log(Level.INFO, "Unregistered generator: " + name);
    }

    @Override
    public @NotNull boolean isRegistered(@NotNull String name) {
        return registeredGenerators.containsKey(name);
    }

    @Override
    public @NotNull Collection<Generator> getRegisteredGenerators() {
        return registeredGenerators.values();
    }
}
