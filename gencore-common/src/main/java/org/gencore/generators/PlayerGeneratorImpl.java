package org.gencore.generators;

import org.bukkit.Location;
import org.bukkit.Material;
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

    @Override
    public void setGenerator(String name) {
        Generator gen = Generator.getGenerators().get(name);
        if (gen == null)
            return;

        this.generator = gen;
        this.location.getBlock().setType(gen.getGenItem().getType());
    }

    @Override
    public void removeGenerator() {
        Material material = this.location.getBlock().getType();
        if (material == null)
            return;

        Map<Material, List<PlayerGenerator>> gens = PlayerGenerator.getGenerators(this.player);
        List<PlayerGenerator> list = gens.get(material);
        if (list.contains(this)) {
            list.remove(this);
            if (list.isEmpty())
                gens.remove(material);
        }

        this.location.getBlock().setType(Material.AIR);
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
