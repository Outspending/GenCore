package org.gencore.builders;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.gencore.utils.ConfigUtils;
import org.jetbrains.annotations.NotNull;
import org.gencore.ItemBuilder;
import org.gencore.utils.ColorUtils;

import java.awt.*;
import java.util.List;

public class ItemBuilderImpl implements ItemBuilder {

    public final ColorUtils utils = new ColorUtils();

    private String name;
    private Material material;
    private List<String> lore;
    private int amount;

    @Override
    public @NotNull ItemBuilder setName(@NotNull String name) {
        this.name = name;
        return this;
    }

    @Override
    public @NotNull ItemBuilder setMaterial(@NotNull Material material) {
        this.material = material;
        return this;
    }

    @Override
    public @NotNull ItemBuilder setLore(@NotNull List<String> lore) {
        this.lore = lore;
        return this;
    }

    @Override
    public @NotNull ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public @NotNull ItemStack build() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(utils.colorizeHex(name));
        meta.setLore(lore.stream().map(utils::colorizeHex).toList());
        item.setItemMeta(meta);
        return item;
    }
}
