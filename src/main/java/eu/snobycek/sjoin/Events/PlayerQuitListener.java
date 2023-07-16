package eu.snobycek.sjoin.Events;

import eu.snobycek.sjoin.SJoin;
import eu.snobycek.sjoin.Util.ConfigManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private ConfigManager configManager;

    public PlayerQuitListener() {
        configManager = SJoin.getInstance().getConfigManager();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (configManager.isLeaveMessageEnabled()) {
            String leaveMessage = configManager.getLeaveMessage().replace("%player%", event.getPlayer().getName());
            String formattedMessage = ChatColor.translateAlternateColorCodes('&', leaveMessage);
            event.setQuitMessage(leaveMessage);
        }
    }
}
