package org.mobgens;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ItemBuilder {

    /**
     * Sets the name of the item
     * @param name
     * @return
     */
    @Contract("_ -> this")
    @NotNull ItemBuilder setName(@NotNull String name);

    /**
     * Sets the material of the item
     * @param material
     * @return
     */
    @Contract("_ -> this")
    @NotNull ItemBuilder setMaterial(@NotNull Material material);

    /**
     * Sets the lore of the item
     * @param lore
     * @return
     */
    @Contract("_ -> this")
    @NotNull ItemBuilder setLore(@NotNull List<String> lore);

    /**
     * Sets the amount of the item
     * @param amount
     * @return
     */
    @Contract("_ -> this")
    @NotNull ItemBuilder setAmount(int amount);

    /**
     * Creates the item stack from the builder
     * @return
     */
    @Contract("-> new")
    @NotNull ItemStack build();
}
