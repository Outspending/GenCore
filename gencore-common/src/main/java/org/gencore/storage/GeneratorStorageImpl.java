package org.gencore.storage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.gencore.Generator;
import org.gencore.GeneratorStorage;
import org.gencore.PlayerGenerator;
import org.gencore.generators.PlayerGeneratorImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class GeneratorStorageImpl implements GeneratorStorage {

    public Map<UUID, Map<Material, List<PlayerGenerator>>> playerGenerators = new HashMap<>();

    @Override
    public @NotNull PlayerGenerator createGenerator(@NotNull Player plr, @NotNull Location location, @NotNull String name) {
        Generator generator = getGenerator(name);
        PlayerGenerator gen = new PlayerGeneratorImpl(plr, location, generator);
        addToStorage(gen);
        return gen;
    }

    @Override
    public @NotNull PlayerGenerator createGenerator(@NotNull Player plr, @NotNull Location location) {
        return null;
    }

    @Override
    public @Nullable PlayerGenerator getGenerator(@NotNull Player plr, @NotNull Location location) {
        return playerGenerators.get(plr.getUniqueId()).get(location.getBlock().getType()).stream()
                .filter(g -> g.getLocation().equals(location))
                .findFirst().orElse(null);
    }

    @Override
    public void removeGenerator(@NotNull Player plr, @NotNull Location location) {
        PlayerGenerator gen = getGenerator(plr, location);
        if (gen == null)
            return;

        removeFromStorage(gen);
    }

    @Override
    public void removeGenerator(@NotNull PlayerGenerator generator) {
        removeFromStorage(generator);
    }

    @Override
    public void upgradeGenerator(@NotNull Player plr, @NotNull Location location) {
        PlayerGenerator gen = getGenerator(plr, location);
        if (gen == null)
            return;

        upgradeFromStorage(gen);
    }

    @Override
    public void upgradeGenerator(@NotNull PlayerGenerator generator) {
        upgradeFromStorage(generator);
    }

    @Override
    public @Nullable Generator getGenerator(@NotNull String name) {
        return Generator.getGenerators().get(name);
    }

    @Override
    public int getAmountOfGenerators(@NotNull Player plr) {
        Map<Material, List<PlayerGenerator>> gens = playerGenerators.get(plr.getUniqueId());
        if (gens == null)
            return 0;

        return gens.values().stream().mapToInt(List::size).sum();
    }

    @Override
    public @Nullable Map<Material, List<PlayerGenerator>> getGenerators(@NotNull Player plr) {
        return playerGenerators.get(plr.getUniqueId());
    }

    @Override
    public @Nullable List<PlayerGenerator> getGenerators(@NotNull Player plr, @NotNull Material material) {
        return playerGenerators.get(plr.getUniqueId()).get(material);
    }

    @Override
    public void addToStorage(@NotNull PlayerGenerator generator) {
        Player player = generator.getPlayer();
        playerGenerators.computeIfAbsent(player.getUniqueId(), k -> new HashMap<>())
                .computeIfAbsent(generator.getGenerator().getGenItem().getType(), k -> new ArrayList<>())
                .add(generator);
    }

    @Override
    public void removeFromStorage(@NotNull PlayerGenerator generator) {
        Player player = generator.getPlayer();
        UUID uuid = player.getUniqueId();
        Material material = Objects.requireNonNull(generator.getGenerator()).getGenItem().getType();

        Map<Material, List<PlayerGenerator>> gens = playerGenerators.get(uuid);
        if (gens == null)
            return;

        List<PlayerGenerator> list = gens.get(material);
        if (list == null)
            return;

        list.remove(generator);
        if (list.isEmpty())
            gens.remove(material);
    }

    @Override
    public void upgradeFromStorage(@NotNull PlayerGenerator generator) {
        removeFromStorage(generator);

        Player plr = generator.getPlayer();
        Map<Material, List<PlayerGenerator>> gens = playerGenerators.get(plr.getUniqueId());
        if (gens == null)
            return;

        Material next = generator.getGenerator().getNextMaterial();
        if (next == null)
            return;

        generator.getPlayer().getWorld().getBlockAt(generator.getLocation()).setType(next);
        gens.computeIfAbsent(next, k -> new ArrayList<>()).add(generator);
    }

    public Map<UUID, Map<Material, List<PlayerGenerator>>> getPlayerGenerators() {
        return playerGenerators;
    }
}
