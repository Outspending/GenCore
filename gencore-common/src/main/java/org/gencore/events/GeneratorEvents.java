package org.gencore.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.gencore.GeneratorStorage;
import org.gencore.PlayerGenerator;
import org.gencore.config.ConfigImpl;
import org.gencore.storage.GeneratorStorageImpl;

public class GeneratorEvents implements Listener {

    public ConfigImpl config = new ConfigImpl();
    public GeneratorStorage storage = new GeneratorStorageImpl();

    @EventHandler(priority = EventPriority.LOWEST)
    public void onGenPlace(BlockPlaceEvent e) {
        Location loc = e.getBlock().getLocation();
        if (!config.getGenWorld().equals(loc.getWorld())) return;

        PlayerGenerator gen = storage.createGenerator(e.getPlayer(), loc);
        Bukkit.getPluginManager().callEvent(new GeneratorPlaceEvent(gen, e.getPlayer()));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onGenBreak(PlayerInteractEvent e) {
        if (e.isCancelled()) return;
        if (e.getHand() != EquipmentSlot.HAND) return;

        Block block = e.getClickedBlock();
        Location loc = block.getLocation();
        if (!config.getGenWorld().equals(loc.getWorld())) return;

        e.setCancelled(true);
        PlayerGenerator generator = storage.getGenerator(e.getPlayer(), loc);
        storage.removeFromStorage(generator);
        block.setType(Material.AIR);
        Bukkit.getPluginManager().callEvent(new GeneratorBreakEvent(generator, e.getPlayer(), loc));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onGenUpgrade(PlayerInteractEvent e) {
        if (e.isCancelled()) return;
        if (e.getHand() != EquipmentSlot.HAND) return;

        Block block = e.getClickedBlock();
        Location loc = block.getLocation();
        if (!config.getGenWorld().equals(loc.getWorld())) return;

        e.setCancelled(true);
        PlayerGenerator generator = storage.getGenerator(e.getPlayer(), loc);
        storage.upgradeFromStorage(generator);
        block.setType(generator.getGenerator().getNextMaterial());
        Bukkit.getPluginManager().callEvent(new GeneratorUpgradeEvent(generator, e.getPlayer()));
    }

    private String replacePlaceholders(Player plr, String str) {
        String newStr = str;
        GeneratorStorage storage = new GeneratorStorageImpl();
        newStr = newStr.replace("%player%", plr.getName());
        newStr = newStr.replace("%amount%", String.valueOf(storage.getAmountOfGenerators(plr)));
        return newStr;
    }
}
