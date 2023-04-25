package org.gencore;

import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.gencore.storage.GeneratorStorageImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DropRunnable implements Runnable {

    public final GeneratorStorageImpl storage = new GeneratorStorageImpl();

    @Override
    public void run() {
        for (Player plr : Bukkit.getOnlinePlayers()) {
            Map<Material, List<PlayerGenerator>> generators = storage.getGenerators(plr);
            if (generators == null)
                continue;

            Iterator<Map.Entry<Material, List<PlayerGenerator>>> entryIterator = generators.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<Material, List<PlayerGenerator>> entry = entryIterator.next();
                int amount = entry.getValue().size();
                PlayerGenerator gen = entry.getValue().get(amount - 1);
                Location dropLocation = gen.getLocation();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Item item = dropLocation.getWorld().dropItemNaturally(dropLocation, gen.getGenerator().getDropItem());
                        item.setVelocity(new Vector());
                    }
                }.runTask(GenCore.getPlugin());
            }
        }
    }
}
