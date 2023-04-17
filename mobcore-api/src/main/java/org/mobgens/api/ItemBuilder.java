package org.mobgens.api;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemBuilder {

    private Material material;
    private String name;
    private List<String> lore;


    public ItemBuilder setMaterial(@NotNull Material material) {
        this.material = material;
        return this;
    }

    public @NotNull ItemBuilder setName(@NotNull String name) {
        this.name = name;
        return this;
    }

    public @NotNull ItemBuilder setLore(@NotNull List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
