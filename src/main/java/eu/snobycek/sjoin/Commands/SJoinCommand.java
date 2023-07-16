package eu.snobycek.sjoin.Commands;

import eu.snobycek.sjoin.SJoin;
import eu.snobycek.sjoin.Util.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SJoinCommand implements CommandExecutor {

    private ConfigManager configManager;

    public SJoinCommand() {
        configManager = SJoin.getInstance().getConfigManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("joinmessage")) {
                if (args.length > 1) {
                    StringBuilder message = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        message.append(args[i]).append(" ");
                    }
                    String formattedMessage = ChatColor.translateAlternateColorCodes('&', message.toString().trim());
                    SJoin.getInstance().getConfigManager().setJoinMessage(formattedMessage);
                    sender.sendMessage("§8[§9SJoin§8] §aJoin message set!");
                } else {
                    sender.sendMessage("§8[§9SJoin§8] §7Usage: §9/sjoin joinmessage <message>");
                }
            } else if (args[0].equalsIgnoreCase("leavemessage")) {
                if (args.length > 1) {
                    StringBuilder message = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        message.append(args[i]).append(" ");
                    }
                    String formattedMessage = ChatColor.translateAlternateColorCodes('&', message.toString().trim());
                    SJoin.getInstance().getConfigManager().setLeaveMessage(formattedMessage);
                    sender.sendMessage("§8[§9SJoin§8] §aLeave message set!");
                } else {
                    sender.sendMessage("§8[§9SJoin§8] §7Usage: §9/sjoin leavemessage <message>");
                }
            } else if (args[0].equalsIgnoreCase("togglejoin")) {
                boolean enabled = SJoin.getInstance().getConfigManager().isJoinMessageEnabled();
                SJoin.getInstance().getConfigManager().setJoinMessageEnabled(!enabled);
                sender.sendMessage("§8[§9SJoin§8] §7Join messages §9" + (enabled ? "disabled" : "enabled") + "!");
            } else if (args[0].equalsIgnoreCase("toggleleave")) {
                boolean enabled = SJoin.getInstance().getConfigManager().isLeaveMessageEnabled();
                SJoin.getInstance().getConfigManager().setLeaveMessageEnabled(!enabled);
                sender.sendMessage("§8[§9SJoin§8] §7Leave messages §9" + (enabled ? "disabled" : "enabled") + "!");
            } else {
                sender.sendMessage("§8[§9SJoin§8] §7Unknown command. Available commands: §9joinmessage§7, §9leavemessage§7, §9togglejoin§7, §9toggleleave");
            }
        } else {
            sender.sendMessage("§8[§9SJoin§8] §7Available commands: §9joinmessage§7, §9leavemessage§7, §9togglejoin§7, §9toggleleave");
        }
        return true;
    }
}

