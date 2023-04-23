package org.mobgens.builders;

import com.google.common.base.Preconditions;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mobgens.Generator;
import org.mobgens.GeneratorBuilder;
import org.mobgens.generators.GeneratorImpl;

import java.util.Objects;

public class GeneratorBuilderImpl implements GeneratorBuilder {

    private String name;
    private Material nextMaterial;
    private ItemStack genItem;
    private ItemStack dropItem;
    private int dropAmount;

    @Override
    public @NotNull GeneratorBuilder setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        return this;
    }

    @Override
    public @NotNull GeneratorBuilder setNextMaterial(@NotNull Material nextMaterial) {
        this.nextMaterial = Objects.requireNonNull(nextMaterial, "Next material cannot be null");
        return this;
    }

    @Override
    public @NotNull GeneratorBuilder setGenItem(@NotNull ItemStack genItem) {
        this.genItem = Objects.requireNonNull(genItem, "Gen item cannot be null");
        return this;
    }

    @Override
    public @NotNull GeneratorBuilder setDropItem(@NotNull ItemStack dropItem) {
        this.dropItem = Objects.requireNonNull(dropItem, "Drop item cannot be null");
        return this;
    }

    @Override
    public @NotNull GeneratorBuilder setDropAmount(int dropAmount) {
        Preconditions.checkArgument(dropAmount > 0, "Drop amount must be greater than 0");

        this.dropAmount = dropAmount;
        return this;
    }

    @Override
    public @Nullable Generator build() {
        return new GeneratorImpl(this.name, this.nextMaterial, this.genItem, this.dropItem, this.dropAmount);
    }
}
