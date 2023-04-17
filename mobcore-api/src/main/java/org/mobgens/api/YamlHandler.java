package org.mobgens.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

public interface YamlHandler {

    FileConfiguration loadFile(@NotNull String path);

    @NotNull
    GeneratorConfiguration loadGenerator(@NotNull FileConfiguration configuration, @NotNull String path);


}
