package org.gencore;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface JsonUtilities extends JsonPlayerGenerators {

    /**
     * Converts an object to json
     * @param object
     * @return
     */
    @Contract("_ -> fail")
    String toJson(@NotNull Object object);

    /**
     * Converts json to an object
     * @param json
     * @param clazz
     * @return
     * @param <T>
     */
    <T> T fromJson(@NotNull String json, @NotNull Class<T> clazz);

}
