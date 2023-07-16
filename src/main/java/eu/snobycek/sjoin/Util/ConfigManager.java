package eu.snobycek.sjoin.Util;

import eu.snobycek.sjoin.SJoin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ConfigManager {

    private FileConfiguration config;
    private File configFile;

    public void loadConfig() {
        SJoin plugin = SJoin.getInstance();
        plugin.saveDefaultConfig();
        configFile = new File(plugin.getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            try {
                InputStream inputStream = plugin.getResource("config.yml");
                Files.copy(inputStream, configFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isJoinMessageEnabled() {
        return config.getBoolean("joinMessageEnabled", true);
    }

    public boolean isLeaveMessageEnabled() {
        return config.getBoolean("leaveMessageEnabled", true);
    }

    public String getJoinMessage() {
        return config.getString("joinMessage", "&a%player% joined the server!");
    }

    public String getLeaveMessage() {
        return config.getString("leaveMessage", "&c%player% left the server!");
    }

    public void setJoinMessageEnabled(boolean enabled) {
        config.set("joinMessageEnabled", enabled);
    }

    public void setLeaveMessageEnabled(boolean enabled) {
        config.set("leaveMessageEnabled", enabled);
    }

    public void setJoinMessage(String message) {
        config.set("joinMessage", message);
    }

    public void setLeaveMessage(String message) {
        config.set("leaveMessage", message);
    }
}
