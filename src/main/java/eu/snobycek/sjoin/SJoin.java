package eu.snobycek.sjoin;

import eu.snobycek.sjoin.Commands.SJoinCommand;
import eu.snobycek.sjoin.Events.PlayerJoinListener;
import eu.snobycek.sjoin.Events.PlayerQuitListener;
import eu.snobycek.sjoin.Util.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SJoin extends JavaPlugin {

    private static SJoin instance;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        instance = this;
        configManager = new ConfigManager();
        configManager.loadConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getCommand("sjoin").setExecutor(new SJoinCommand());
    }

    @Override
    public void onDisable() {
        configManager.saveConfig();
    }

    public static SJoin getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
