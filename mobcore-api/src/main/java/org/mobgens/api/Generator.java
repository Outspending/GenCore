package org.mobgens.api;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class Generator {

    private final String name;
    private final Material material;
    private final double generatorCost;
    private final ItemStack generatorItem;
    private final ItemStack generatorDrop;

    public Generator(String name, Material material, double generatorCost, ItemStack generatorItem, ItemStack generatorDrop) {
        this.name = name;
        this.material = material;
        this.generatorCost = generatorCost;
        this.generatorItem = generatorItem;
        this.generatorDrop = generatorDrop;
    }

    public Material getMaterial() {
        return material;
    }

    public double getGeneratorCost() {
        return generatorCost;
    }

    public ItemStack getGeneratorItem() {
        return generatorItem;
    }

    public ItemStack getGeneratorDrop() {
        return generatorDrop;
    }
}
