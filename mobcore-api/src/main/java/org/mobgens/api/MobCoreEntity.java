package org.mobgens.api;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface MobCoreEntity<T extends GeneratorEntity, V extends Entity> {

    @NotNull V spawn(@NotNull T entity, @NotNull Location location);

    @NotNull V despawn(@NotNull T entity);

    @NotNull String setDisplayName(@NotNull String name);

    @NotNull int setAmount(@NotNull int amount);

    @NotNull String setNameFormat(@NotNull String nameFormat);

    @NotNull Optional<T> hasNameFormat();

    @Nullable String getNameFormat();

    @Nullable String getDisplayName();

}

