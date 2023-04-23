package org.mobgens.generators;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.mobgens.Generator;

public class GeneratorImpl implements Generator {

    private final String name;
    private final Material nextMaterial;
    private final ItemStack genItem;
    private final ItemStack dropItem;
    private final int dropAmount;

    public GeneratorImpl(String name, Material nextMaterial, ItemStack genItem, ItemStack dropItem, int dropAmount) {
        this.name = name;
        this.nextMaterial = nextMaterial;
        this.genItem = genItem;
        this.dropItem = dropItem;
        this.dropAmount = dropAmount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public @Nullable Material getNextMaterial() {
        return this.nextMaterial;
    }

    @Override
    public @Nullable ItemStack getGenItem() {
        return this.genItem;
    }

    @Override
    public @Nullable ItemStack getDropItem() {
        return this.dropItem;
    }

    @Override
    public int getDropAmount() {
        return this.dropAmount;
    }
}
