package org.mobgens.api;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class PlayerGenerator extends IPlayerGenerator implements PlayerGeneratorHandler {

    protected PlayerGenerator(UUID owner, Generator generator) {
        super(owner, generator);
    }

    @Override
    public @NotNull Generator getGenType() {
        Map<String, Generator> gens = RegistryHandler.registeredGenerators;
        return gens.values().stream()
                .filter(gen -> gen.getMaterial().equals(getGenerator().getMaterial()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public @NotNull GeneratorConfiguration getGenConfiguration() {
        // TODO: Implement this method
        return null;
    }

    @NotNull
    @Override
    public PlayerGenerator updateGenerator(@NotNull PlayerGenerator generator) {
        // TODO: Implement this method
        return null;
    }

    @NotNull
    @Override
    public PlayerGenerator updateGenerator(@NotNull PlayerGenerator generator, @NotNull GeneratorConfiguration configuration) {
        // TODO: Implement this method
        return null;
    }
}
