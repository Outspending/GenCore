package org.mobgens;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public interface ColorUtilities {

    /**
     * Colorizes a string using the & character.
     * Is used to colorize strings in the plugin.
     * @param string
     * @return
     */
    @Contract(pure = true)
    String colorize(@NotNull String string);

    /**
     * Colorizes a string using the &# character.
     * This can be used for adding hex codes to strings.
     * @param string
     * @return
     */
    @Contract(pure = true)
    String colorizeHex(@NotNull String string);

}
