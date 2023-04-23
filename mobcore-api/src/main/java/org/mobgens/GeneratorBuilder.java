package org.mobgens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface GeneratorBuilder {

    /**
     * Set the name of the generator
     * @param name
     * @return
     */
    @Contract("_ -> this")
    @NotNull GeneratorBuilder setName(String name);

    /**
     * Set the next material of the generator
     * @param nextMaterial
     * @return
     */
    @Contract("_ -> this")
    @NotNull GeneratorBuilder setNextMaterial(@NotNull Material nextMaterial);

    /**
     * Sets the generators item
     * @param genItem
     * @return
     */
    @Contract("_ -> this")
    @NotNull GeneratorBuilder setGenItem(@NotNull ItemStack genItem);

    /**
     * Sets the generators droppped item
     * @param dropItem
     * @return
     */
    @Contract("_ -> this")
    @NotNull GeneratorBuilder setDropItem(@NotNull ItemStack dropItem);

    /**
     * Set the drop amount per generator
     * @param dropAmount
     * @return
     */
    @Contract("_ -> this")
    @NotNull GeneratorBuilder setDropAmount(int dropAmount);

    /**
     * Builds the generator
     * @return
     */
    @Contract(" -> new")
    @Nullable Generator build();

}
