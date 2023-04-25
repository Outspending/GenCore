package org.gencore.utils;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {

    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");

    public String colorize(@NotNull String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public String colorizeHex(@NotNull String string) {
        Matcher matcher = HEX_PATTERN.matcher(string);
        while (matcher.find()) {
            String color = matcher.group(1);
            string = string.replace(matcher.group(), ChatColor.of("#" + color).toString());
        }
        return colorize(string);
    }

    public Pattern getHexPattern() {
        return HEX_PATTERN;
    }
}
