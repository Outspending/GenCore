package org.gencore;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public interface Generator {

    @NotNull Map<String, Generator> generators = new HashMap<>();

    /**
     * Get the name of the generator
     * @return
     */
    String getName();

    /**
     * Get the next material of the generator
     * @return
     */
    @Nullable Material getNextMaterial();

    /**
     * Get the item that is used for the next generator
     * @return
     */
    @Nullable ItemStack getGenItem();

    /**
     * Get the dropped item once generators generate
     * @return
     */
    @Nullable ItemStack getDropItem();

    /**
     * Get the drop amount per generator
     * @return
     */
    double getCost();

    static Map<String, Generator> getGenerators() {
        return generators;
    }
}
