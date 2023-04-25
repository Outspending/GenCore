package org.gencore;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PlayerGenerator {

    /**
     * Sets the generator type
     * @param name
     */
    @Contract("null -> fail")
    void setGenerator(String name);

    /**
     * Gets the generator type
     * @return
     */
    @Nullable Generator getGenerator();

    /**
     * Gets the location of the generator
     * @return
     */
    @Nullable Location getLocation();

    /**
     * Gets the player that owns the generator
     * @return
     */
    @Nullable Player getPlayer();

}
