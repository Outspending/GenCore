package org.mobgens.utils;

import com.google.gson.Gson;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mobgens.Generator;
import org.mobgens.JsonUtilities;

import java.util.List;
import java.util.Map;

public class JsonUtils implements JsonUtilities {

    private static final Gson gson = new Gson();

    @Override
    public String generatorToJson(@NotNull List<Generator> generators) {
        // TODO: Rework this method to convert a list of generators to json
        return gson.toJson(generators);
    }

    @Override
    public @Nullable List<Generator> jsonToGenerators(String json) {
        return gson.fromJson(json, List.class);
    }

    @Override
    public @Nullable Map<Material, List<Generator>> jsonToPlayerGenerators(String json) {
        // TODO: Implement this method to convert json to a map of generators
        return null;
    }

    @Override
    public String toJson(@NotNull Object object) {
        // TODO: Implement this method to convert an object to json
        return null;
    }

    @Override
    public <T> T fromJson(@NotNull String json, @NotNull Class<T> clazz) {
        // TODO: Implement this method to convert json to an object
        return null;
    }
}
