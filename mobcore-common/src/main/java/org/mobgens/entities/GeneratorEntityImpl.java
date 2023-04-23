package org.mobgens.entities;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.mobgens.GeneratorEntity;

public class GeneratorEntityImpl implements GeneratorEntity {

    private final Entity entity;
    private final String name;
    private final int amount;
    private Location location;


    public GeneratorEntityImpl(Entity entity, String name, int amount) {
        Entity entity1 = entity;
        entity1.setCustomNameVisible(true);
        entity1.setCustomName(name);
        this.entity = entity;
        this.name = name;
        this.amount = amount;
    }

    public GeneratorEntityImpl(Entity entity, String name, int amount, Location location) {
        Entity entity1 = entity;
        entity1.setCustomNameVisible(true);
        entity1.setCustomName(name);
        this.entity = entity;
        this.name = name;
        this.amount = amount;
        this.location = location;
    }

    @Override
    public @NotNull GeneratorEntity createEntity(@NotNull Entity entity, @NotNull String name, int amount) {
        return new GeneratorEntityImpl(entity, name, amount);
    }

    @Override
    public @NotNull GeneratorEntity createEntity(@NotNull Entity entity, @NotNull String name, int amount, @NotNull Location location) {
        GeneratorEntity entity1 = new GeneratorEntityImpl(entity, name, amount, location);
        entity1.spawn();
        return entity1;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public @NotNull Entity getEntity() {
        return this.entity;
    }

    @Override
    public @NotNull Location getLocation() {
        return this.location;
    }

    @Override
    public void spawn(Location location) {
        this.entity.spawnAt(location);
    }

    @Override
    public void spawn() {
        if (this.location != null)
            this.entity.spawnAt(this.location);
    }

    @Override
    public void kill() {
        if (!this.entity.isDead())
            this.entity.remove();
    }
}
