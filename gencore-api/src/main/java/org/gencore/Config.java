package org.gencore;

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
    <T> @Nullable T checkType(@NotNull T type);
}
