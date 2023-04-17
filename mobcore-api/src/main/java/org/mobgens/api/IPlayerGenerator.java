package org.mobgens.api;

import java.util.UUID;

public abstract class IPlayerGenerator {

    private final UUID owner;
    private final Generator generator;

    protected IPlayerGenerator(UUID owner, Generator generator) {
        this.owner = owner;
        this.generator = generator;
    }

    public UUID getOwner() {
        return owner;
    }

    public Generator getGenerator() {
        return generator;
    }
}
