package org.gencore.generators;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.gencore.Generator;

public class GeneratorImpl implements Generator {

    private final String name;
    private final Material nextMaterial;
    private final ItemStack genItem;
    private final ItemStack dropItem;
    private final double cost;

    public GeneratorImpl(String name, Material nextMaterial, ItemStack genItem, ItemStack dropItem, double cost) {
        this.name = name;
        this.nextMaterial = nextMaterial;
        this.genItem = genItem;
        this.dropItem = dropItem;
        this.cost = cost;
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
    public double getCost() {
        return this.cost;
    }
}
