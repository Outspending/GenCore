package org.mobgens.api;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface RegistryHandler<T extends Generator> {

    Map<String, Generator> registeredGenerators = new HashMap<>();

    void registerAllGenerators();

    void registerGenerator(@NotNull String name);

    void unregisterGenerator(@NotNull String name);

    @NotNull
    boolean isRegistered(@NotNull String name);

    @NotNull
    Collection<T> getRegisteredGenerators();

}
