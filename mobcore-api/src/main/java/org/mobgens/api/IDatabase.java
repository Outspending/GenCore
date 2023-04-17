package org.mobgens.api;

import org.bukkit.plugin.Plugin;

public abstract class IDatabase {

    private static String STORAGE_URL;
    private static Plugin plugin;

    public static String getURL() {
        return STORAGE_URL;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static void setURL(String storageUrl) {
        STORAGE_URL = storageUrl;
    }

    public static void setPlugin(Plugin plugin) {
        IDatabase.plugin = plugin;
    }
}
