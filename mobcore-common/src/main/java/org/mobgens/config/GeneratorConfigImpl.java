package org.mobgens.config;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Mob;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.mobgens.Generator;
import org.mobgens.GeneratorConfig;
import org.mobgens.MobCore;
import org.mobgens.builders.ItemBuilderImpl;
import org.mobgens.generators.GeneratorImpl;
import org.mobgens.utils.ConfigUtils;

import java.io.File;

public class GeneratorConfigImpl implements GeneratorConfig {

    private final YamlConfiguration CONFIG_FILE = ConfigUtils.check(new File(MobCore.getPlugin(MobCore.class).getDataFolder(), "generators.yml"), "generators.yml");

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
    }

    @Override
    public @Nullable Generator registerGenerator(String path) {
        return registerGenerator(CONFIG_FILE, path);
    }

    @Override
    public @Nullable Generator registerGenerator(YamlConfiguration config, String path) {
        if (config == null)
            throw new IllegalArgumentException();

        try {
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

            final Generator generator = new GeneratorImpl(name, next, item, drop, 1);
            MobCore.getPlugin().getLogger().info("Registered generator " + path + "!");
        } catch (IllegalArgumentException e) {
            MobCore.getPlugin().getLogger().severe("There was an issue loading generator " + path + "!");
            e.printStackTrace();
        }

        return null;
    }
}
