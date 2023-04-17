package org.mobgens.api.utils;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {

    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");

    public static @NotNull String colorize(@NotNull String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static @NotNull String colorizeHex(@NotNull String str) {
        Matcher matcher = HEX_PATTERN.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            str = str.replace(matcher.group(), ChatColor.of("#" + group) + "");
        }
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static @NotNull String stripColor(@NotNull String str) {
        return ChatColor.stripColor(str);
    }
}
