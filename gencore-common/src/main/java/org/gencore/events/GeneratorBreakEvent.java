package org.gencore.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.gencore.PlayerGenerator;
import org.jetbrains.annotations.NotNull;

public class GeneratorBreakEvent extends Event {

    private PlayerGenerator generator;
    private Player player;
    private Location location;

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public GeneratorBreakEvent(PlayerGenerator generator, Player player, Location location) {
        this.generator = generator;
        this.player = player;
        this.location = location;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public PlayerGenerator getGenerator() {
        return generator;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getLocation() {
        return location;
    }
}
