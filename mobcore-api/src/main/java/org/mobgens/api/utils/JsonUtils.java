package org.mobgens.api.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class JsonUtils {

    public static @Nullable List<UUID> fromJson(String json) {
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<UUID>>() {}.getType();
            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static @Nullable String toJson(@NotNull List<UUID> uuids) {
        try {
            Gson gson = new Gson();
            return gson.toJson(uuids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
