package org.mobgens.api;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface RegistryHandler {

    void registerAllGenerators();

    void registerGenerator(@NotNull String name);

    void unregisterGenerator(@NotNull String name);

    @NotNull
    boolean isRegistered(@NotNull String name);

    @NotNull
    Collection<Generator> getRegisteredGenerators();

}
