package eu.snobycek.sjoin.Events;

import eu.snobycek.sjoin.SJoin;
import eu.snobycek.sjoin.Util.ConfigManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
public class PlayerJoinListener implements Listener {

    private ConfigManager configManager;

    public PlayerJoinListener() {
        configManager = SJoin.getInstance().getConfigManager();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (configManager.isJoinMessageEnabled()) {
            String joinMessage = configManager.getJoinMessage().replace("%player%", event.getPlayer().getName());
            String formattedMessage = ChatColor.translateAlternateColorCodes('&', joinMessage);
            event.setJoinMessage(formattedMessage);
        }
    }
}
