package org.mobgens.storage;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mobgens.api.DatabaseHandler;
import org.mobgens.api.IDatabase;
import org.mobgens.MobCore;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;

public class MobDatabase extends IDatabase implements DatabaseHandler {


    static {
        setURL("jdbc:sqlite:" + MobCore.getPlugin().getDataFolder().getAbsolutePath() + "\\database.db");
    }

    @Override
    public @Nullable Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(getURL());
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS generators (uuid VARCHAR(36), generators text)";
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createPlayerData(@NotNull String uuid, @NotNull String generators) {
        String sql = "INSERT INTO generators (uuid, generators) VALUES (?, ?)";
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, uuid);
            statement.setString(2, generators);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePlayerData(@NotNull String uuid, @NotNull String generators) {
        String sql = "UPDATE generators SET generators = ? WHERE uuid = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, generators);
            statement.setString(2, uuid);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAllData() {
        // TODO Auto-generated method stub
    }

    @Override
    public void deletePlayerData(@NotNull String uuid) {
        String sql = "DELETE FROM generators WHERE uuid = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, uuid);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public @Nullable String getPlayerData(@NotNull String uuid) {
        String sql = "SELECT * FROM generators WHERE uuid = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, uuid);
            ResultSet set = statement.executeQuery();
            statement.close();
            return set.getString("generators");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void checkDatabase() {
        Plugin plugin = MobCore.getPlugin();
        File file = plugin.getDataFolder();
        if (!file.exists()) {
            file.mkdir();
            createTable();
            plugin.getLogger().log(Level.INFO, "Successfully created database!");
        }
    }
}
