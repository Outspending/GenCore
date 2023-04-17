package org.mobgens.api;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.sql.Connection;

public interface DatabaseHandler {

    @Nullable
    Connection getConnection();

    void createTable();

    void createPlayerData(@NotNull String uuid, @NotNull String generators);

    void updatePlayerData(@NotNull String uuid, @NotNull String generators);

    void updateAllData();

    void deletePlayerData(@NotNull String uuid);

    @Nullable
    String getPlayerData(@NotNull String uuid);

    void checkDatabase();
}
