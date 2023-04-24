package org.gencore.config;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;
import org.gencore.Generator;
import org.gencore.GeneratorConfig;
import org.gencore.GenCore;
import org.gencore.builders.ItemBuilderImpl;
import org.gencore.generators.GeneratorImpl;
import org.gencore.utils.ConfigUtils;

import java.io.File;
import java.util.logging.Level;

public class GeneratorConfigImpl implements GeneratorConfig {

    private final YamlConfiguration CONFIG_FILE = ConfigUtils.check(new File(GenCore.getPlugin(GenCore.class).getDataFolder(), "generators.yml"), "generators.yml");

    @Override
    public void load() {
        registerAllGenerators();
    }

    @Override
    public <T> @Nullable T checkType(T type) {
        if (type == null)
            throw new IllegalArgumentException();
        return type;
    }

    @Override
    public void registerAllGenerators() {
        for (String path : CONFIG_FILE.getConfigurationSection("generators").getKeys(false)) {
            registerGenerator(CONFIG_FILE, path);
        }
        Plugin plugin = GenCore.getPlugin();
        plugin.getLogger().log(Level.INFO, "Successfully registered " + registeredGenerators.size() + " generators!");
    }

    @Override
    public @Nullable Generator registerGenerator(String path) {
        return registerGenerator(CONFIG_FILE, path);
    }

    @Override
    public @Nullable Generator registerGenerator(YamlConfiguration config, String path) {
        if (config == null)
            throw new IllegalArgumentException();

        JavaPlugin plugin = GenCore.getPlugin();
        try {
            if (registeredGenerators.values().contains(path))
                plugin.getLogger().log(Level.WARNING, "Generator with name '" + path + "' is already registered!");

            final String name = checkType(path);
            final double cost = checkType(config.getDouble("generators." + path + ".upgrade_cost"));
            final Material next = Material.getMaterial(checkType(config.getString("generators." + path + ".next")));

            final ItemStack item = new ItemBuilderImpl()
                    .setMaterial(Material.getMaterial(checkType(config.getString("generators." + path + ".item.material"))))
                    .setName(checkType(config.getString("generators." + path + ".item.name")))
                    .setLore(config.getStringList("generators." + path + ".item.lore"))
                    .build();

            final ItemStack drop = new ItemBuilderImpl()
                    .setMaterial(Material.getMaterial(checkType(config.getString("generators." + path + ".drop.material"))))
                    .setName(checkType(config.getString("generators." + path + ".drop.name")))
                    .setLore(config.getStringList("generators." + path + ".drop.lore"))
                    .build();

            final Generator generator = new GeneratorImpl(name, next, item, drop, cost);
            registeredGenerators.put(name, generator);
            return generator;
        } catch (IllegalArgumentException e) {
            plugin.getLogger().severe("There was an issue loading generator " + path + "! (" + e.getMessage() + ")");
            return null;
        }
    }
}
