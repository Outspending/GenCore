package org.mobgens;

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
     * The player generators
     */
    @Nullable Map<UUID, Map<Material, List<Generator>>> playerGenerators = new HashMap<>();

    /**
     * Sets the generator type
     * @param name
     */
    @Contract("null -> fail")
    void setGenerator(String name);

    /**
     * Removes the generator type
     */
    void removeGenerator();

    /**
     * Gets the generator type
     * @return
     */
    @Contract("-> fail")
    @Nullable Generator getGenerator();

    /**
     * Gets the location of the generator
     * @return
     */
    @Contract("-> fail")
    @Nullable Location getLocation();

    /**
     * Gets the player that owns the generator
     * @return
     */
    @Contract("-> fail")
    @Nullable Player getPlayer();

    /**
     * Gets the all the player generators
     * @return
     */
    static Map<UUID, Map<Material, List<Generator>>> getPlayerGenerators() {
        return playerGenerators;
    }

    /**
     * Gets the player generators
     * @param player
     * @return
     */
    static Map<Material, List<Generator>> getGenerators(Player player) {
        playerGenerators.computeIfAbsent(player.getUniqueId(), k -> new HashMap<>());
        return playerGenerators.get(player.getUniqueId());
    }

    /**
     * Gets the player generators with the material
     * @param player
     * @param material
     * @return
     */
    static List<Generator> getGenMaterials(Player player, Material material) {
        playerGenerators.computeIfAbsent(player.getUniqueId(), k -> new HashMap<>());
        return playerGenerators.get(player.getUniqueId()).get(material);
    }
}
