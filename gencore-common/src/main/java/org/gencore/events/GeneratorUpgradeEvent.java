package org.gencore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.gencore.PlayerGenerator;
import org.jetbrains.annotations.NotNull;

public class GeneratorUpgradeEvent extends Event {

    private PlayerGenerator generator;
    private Player player;

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public GeneratorUpgradeEvent(PlayerGenerator generator, Player player) {
        this.generator = generator;
        this.player = player;
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
}
