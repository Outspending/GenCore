package org.gencore;

import org.bukkit.Material;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface JsonPlayerGenerators {

    /**
     * Converts a list of generators to json
     * @param generators
     * @return
     */
    String generatorToJson(@NotNull List<Generator> generators);

    /**
     * Converts a map of generators to json
     * @param json
     * @return
     */
    @Contract("null -> fail")
    @Nullable List<Generator> jsonToGenerators(String json);

    /**
     * Converts a map of generators to json
     * @param json
     * @return
     */
    @Contract("null -> fail")
    @Nullable Map<Material, List<Generator>> jsonToPlayerGenerators(String json);
}
