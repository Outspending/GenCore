package org.mobgens.api;

import org.jetbrains.annotations.NotNull;

public interface PlayerGeneratorHandler<T extends PlayerGenerator> {

    @NotNull Generator getGenType();

    @NotNull GeneratorConfiguration getGenConfiguration();

    @NotNull T updateGenerator(@NotNull T generator);

    @NotNull T updateGenerator(@NotNull T generator, @NotNull GeneratorConfiguration configuration);
}
