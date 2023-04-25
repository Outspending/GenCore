package org.gencore;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface GeneratorStorage {

    /**
     * Create a generator
     * @param plr
     * @param location
     * @param name
     * @return
     */
    @NotNull PlayerGenerator createGenerator(@NotNull Player plr, @NotNull Location location, @NotNull String name);

    /**
     * Create a generator
     * @param plr
     * @param location
     * @return
     */
    @NotNull PlayerGenerator createGenerator(@NotNull Player plr, @NotNull Location location);

    /**
     * Get a generator
     * @param plr
     * @param location
     * @return
     */
    @Nullable PlayerGenerator getGenerator(@NotNull Player plr, @NotNull Location location);

    /**
     * Removes a generator
     * @param plr
     * @param location
     */
    void removeGenerator(@NotNull Player plr, @NotNull Location location);

    /**
     * Removes a generator
      * @param generator
     */
    void removeGenerator(@NotNull PlayerGenerator generator);

    /**
     * Upgrades a generator
     * @param plr
     * @param location
     */
    void upgradeGenerator(@NotNull Player plr, @NotNull Location location);

    /**
     * Upgrades a generator
     * @param generator
     */
    void upgradeGenerator(@NotNull PlayerGenerator generator);

    /**
     * Gets a generator
     * @param name
     * @return
     */
    @Nullable Generator getGenerator(@NotNull String name);

    /**
     * Gets the amount of generators
     * @param plr
     * @return
     */
    int getAmountOfGenerators(@NotNull Player plr);

    /**
     * Gets the generators
     * @param plr
     * @return
     */
    @Nullable Map<Material, List<PlayerGenerator>> getGenerators(@NotNull Player plr);

    /**
     * Gets the generators
     * @param plr
     * @param material
     * @return
     */
    @Nullable List<PlayerGenerator> getGenerators(@NotNull Player plr, @NotNull Material material);

    /**
     * Adds a generator to storage
     * @param generator
     */
    void addToStorage(@NotNull PlayerGenerator generator);

    /**
     * Removes a generator from storage
     * @param generator
     */
    void removeFromStorage(@NotNull PlayerGenerator generator);

    /**
     * Upgrades a generator from storage
     * @param generator
     */
    void upgradeFromStorage(@NotNull PlayerGenerator generator);

}
