package org.mobgens;

import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Config {

    /**
     * Loading function for the config
     * @return
     */
    void load();

    /**
     * Checks if the config contains a key
     * @param type
     * @return
     */
    @Contract("null -> fail")
    <T> @Nullable T checkType(T type);
}
