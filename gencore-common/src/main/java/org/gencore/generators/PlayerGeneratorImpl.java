package org.gencore.generators;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import org.gencore.Generator;
import org.gencore.PlayerGenerator;

import java.util.List;
import java.util.Map;

public class PlayerGeneratorImpl implements PlayerGenerator {

    private final Player player;
    private final Location location;
    private Generator generator;

    public PlayerGeneratorImpl(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    public PlayerGeneratorImpl(Player player, Location location, Generator generator) {
        this.player = player;
        this.location = location;
        this.generator = generator;
    }

    @Override
    public void setGenerator(String name) {
        Generator gen = Generator.getGenerators().get(name);
        if (gen == null)
            return;

        this.generator = gen;
        this.location.getBlock().setType(gen.getGenItem().getType());
    }

    @Override
    public @Nullable Generator getGenerator() {
        return this.generator;
    }

    @Override
    public @Nullable Location getLocation() {
        return this.location;
    }

    @Override
    public @Nullable Player getPlayer() {
        return this.player;
    }
}
