package org.gencore;

import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public interface GeneratorConfig extends Config {

    /**
     * The map for all registeredGenerators
     */
    @NotNull Map<String, Generator> registeredGenerators = new HashMap<>();

    /**
     * Registers all generators
     */
    void registerAllGenerators();

    /**
     * Registers a generator
     * @param path
     * @return
     */
    @Contract("null -> fail")
    @Nullable Generator registerGenerator(String path);

    /**
     * Registers a generator with the config
     * @param config
     * @param path
     * @return
     */
    @Contract("null, _ -> fail")
    @Nullable Generator registerGenerator(YamlConfiguration config, String path);

    /**
     * Get all registered generators
     * @return
     */
    @Contract(pure = true)
    static @NotNull Map<String, Generator> getRegisteredGenerators() {
        return registeredGenerators;
    }

    /**
     * Get a generator by name from the registered generators
     * @param name
     * @return
     */
    @Contract("null -> fail")
    static @Nullable Generator getGenerator(String name) {
        return registeredGenerators.get(name);
    }
}
