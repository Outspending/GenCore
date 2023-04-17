package org.mobgens.api;

import org.bukkit.plugin.Plugin;

public abstract class IDatabase {

    private static String STORAGE_URL;

    public static String getURL() {
        return STORAGE_URL;
    }


    public static void setURL(String storageUrl) {
        STORAGE_URL = storageUrl;
    }
}
