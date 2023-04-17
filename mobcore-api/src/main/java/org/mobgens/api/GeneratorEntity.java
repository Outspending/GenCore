package org.mobgens.api;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mobgens.api.utils.ColorUtils;

import java.util.Optional;

public class GeneratorEntity implements MobCoreEntity {

    private final Entity entity;
    private int amount = 0;
    private String nameFormat;

    public GeneratorEntity(Entity entity, int amount, String nameFormat) {
        this.entity = entity;
        this.amount = amount;
        this.nameFormat = nameFormat;
        this.entity.setCustomNameVisible(true);
    }

    @NotNull
    @Override
    public Entity spawn(@NotNull GeneratorEntity entity, @NotNull Location location) {
        Entity e = this.entity;
        if (e == null)
            return null;

        e.spawnAt(location);
        return e;
    }

    @NotNull
    @Override
    public Entity despawn(@NotNull GeneratorEntity entity) {
        Entity e = this.entity;
        if (e instanceof Damageable damage)
            damage.setHealth(0);

        return e;
    }

    @Override
    public @NotNull String setDisplayName(@NotNull String name) {
        Entity e = this.entity;
        if (e == null)
            return "";

        String colored = ColorUtils.colorizeHex(name);
        e.setCustomName(colored);
        return colored;
    }

    @Override
    public @NotNull int setAmount(@NotNull int amount) {
        Preconditions.checkArgument(amount > 0, "Amount must be greater than 0");
        this.amount = amount;
        return amount;
    }

    @Override
    public @NotNull String setNameFormat(@NotNull String nameFormat) {
        this.nameFormat = nameFormat;
        return nameFormat;
    }

    @Override
    public @NotNull Optional<String> hasNameFormat() {
        String nameFormat = this.nameFormat;
        if (nameFormat == null)
            return Optional.empty();

        return Optional.ofNullable(this.nameFormat);
    }

    @Override
    public @Nullable String getNameFormat() {
        return this.nameFormat;
    }

    @Override
    public @Nullable String getDisplayName() {
        return this.entity.getCustomName();
    }
}
