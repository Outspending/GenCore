package org.mobgens;

import org.apache.maven.model.Resource;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public interface ConfigUtilities {

    /**
     * Creates a config file while copying the resource
     * @param file
     * @return
     */
    @Contract("null, null -> fail")
    @Nullable YamlConfiguration createConfigWithResource(File file, Resource resource);

    /**
     * Gets a config file
     * @param file
     * @return
     */
    @Contract("null -> fail")
    @Nullable YamlConfiguration getConfig(File file);

    /**
     * Checks if the file exists
     * @param file
     * @return
     */
    @Contract("null, _ -> false")
    boolean check(File file, @NotNull Resource resource);
}
