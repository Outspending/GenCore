package org.mobgens;

import org.bukkit.Location;

public interface GeneratorEntity extends MobEntity {

    /**
     * Spawns a {@link GeneratorEntity} at the location
     * @param location
     */
    void spawn(Location location);

    /**
     * Spawns a {@link GeneratorEntity}
     */
    void spawn();

    /**
     * Kills the {@link GeneratorEntity}
     */
    void kill();

}
