package me.beat.hideplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.util.Collection;

public class HideCommand implements CommandExecutor {

    public static Hideplugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
        {
            Player p = (Player)sender;
            if (plugin.playerHidingIndex(p) != -1) p.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD +
                    "HidePlayers" + ChatColor.RED + "] " + ChatColor.YELLOW + "You have already hidden all players! Use " + ChatColor.AQUA + "/show " + ChatColor.YELLOW + "to show them again.");
            else {
                for (Player pl : Bukkit.getServer().getOnlinePlayers()) p.hidePlayer(plugin, pl);
                addHideSender(p);
                p.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD +
                        "HidePlayers" + ChatColor.RED + "] " + ChatColor.YELLOW + "You hid all players! Use " + ChatColor.AQUA + "/show " + ChatColor.YELLOW + "to show them again.");
            }
        }

        else sender.sendMessage("This command can't be executed by the console!");

        return true;
    }

    public void addHideSender(Player p)
    {
        Player[] newArr = new Player[plugin.senders.length + 1];
        for (int i = 0; i < plugin.senders.length; i++) newArr[i] = plugin.senders[i];
        newArr[plugin.senders.length] = p;
        plugin.senders = newArr;
    }
}
