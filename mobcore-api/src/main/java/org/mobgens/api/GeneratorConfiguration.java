package org.mobgens.api;

import com.google.common.base.Preconditions;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GeneratorConfiguration {

    private static FileConfiguration configuration;
    private static String path;

    public GeneratorConfiguration(@NotNull FileConfiguration configuration, @NotNull String path) {
        this.configuration = configuration;
        this.path = path;
    }

    public static @NotNull GeneratorConfiguration load(@NotNull FileConfiguration configuration, @NotNull String path) {
        return new GeneratorConfiguration(configuration, path);
    }

    public static @Nullable List<String> getGeneratorList() {
        return configuration.getStringList(path + ".generators");
    }

    public @NotNull String getName() {
        String name = configuration.getString(path + ".name");
        Preconditions.checkArgument(name != null, "Generator name cannot be null");

        return name;
    }

    public @NotNull String getMaterial() {
        String material = configuration.getString(path + ".material");
        Preconditions.checkArgument(material != null, "Generator material cannot be null");

        return material;
    }

    public @NotNull double getCost() {
        double cost = configuration.getDouble(path + ".cost");
        Preconditions.checkArgument(cost != 0, "Generator cost cannot be 0");

        return cost;
    }

    public @NotNull ItemStack getGenItem() {
        Material type = Material.getMaterial(configuration.getString(path + ".item.type"));
        String genName = configuration.getString(path + ".item.name");
        List<String> genLore = configuration.getStringList(path + ".item.lore");

        try {
            Preconditions.checkNotNull(type, "Item type cannot be null");
            Preconditions.checkNotNull(genName, "Item name cannot be null");
            Preconditions.checkNotNull(genLore, "Item lore cannot be null");
        } catch (NullPointerException e) {
            throw new IllegalStateException("Failed to get item or drop material", e);
        }

        ItemStack genItem = new ItemBuilder()
                .setName(genName)
                .setLore(genLore)
                .setMaterial(type)
                .build();

        Preconditions.checkNotNull(genItem, "Generator item cannot be null");
        return genItem;
    }

    public @NotNull ItemStack getDropItem() {
        Material type = Material.getMaterial(configuration.getString(path + ".drop.type"));
        String dropName = configuration.getString(path + ".drop.name");
        List<String> dropLore = configuration.getStringList(path + ".drop.lore");

        try {
            Preconditions.checkNotNull(type, "Item type cannot be null");
            Preconditions.checkNotNull(dropName, "Item name cannot be null");
            Preconditions.checkNotNull(dropLore, "Item lore cannot be null");
        } catch (NullPointerException e) {
            throw new IllegalStateException("Failed to get item or drop material", e);
        }

        ItemStack dropItem = new ItemBuilder()
                .setName(dropName)
                .setLore(dropLore)
                .setMaterial(type)
                .build();

        Preconditions.checkNotNull(dropItem, "Generator drop item cannot be null");
        return dropItem;
    }

    public @NotNull Generator getGenerator() {
        return new Generator(getName(), Material.getMaterial(getMaterial()), getCost(), getGenItem(), getDropItem());
    }
}
