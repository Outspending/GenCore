package org.mobgens;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MobEntity {

    /**
     * Creates a {@link GeneratorEntity}
     * @param entity
     * @param name
     * @param amount
     * @return
     */
    @NotNull GeneratorEntity createEntity(@NotNull Entity entity, @NotNull String name, int amount);

    /**
     * Creates a {@link GeneratorEntity} and spawns it at the location
     * @param entity
     * @param name
     * @param amount
     * @param location
     * @return
     */
    @NotNull GeneratorEntity createEntity(@NotNull Entity entity, @NotNull String name, int amount, @NotNull Location location);

    /**
     * Gets the amount of the entity
     * @return
     */
    @Contract(pure = true)
    int getAmount();

    /**
     * Gets the name of the entity
     * @return
     */
    @Contract(pure = true)
    @Nullable String getName();

    /**
     * Gets the entity
     * @return
     */
    @Contract(pure = true)
    @Nullable Entity getEntity();

    /**
     * Gets the location of the entity
     * @return
     */
    @Contract(pure = true)
    @Nullable Location getLocation();

}
