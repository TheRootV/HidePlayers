package me.beat.hideplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowCommand implements CommandExecutor {

    public static Hideplugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
        {
            Player p = (Player)sender;
            int index = plugin.playerHidingIndex(p);
            if (index == -1) p.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD +
                    "HidePlayers" + ChatColor.RED + "] " + ChatColor.YELLOW + "You can't use the show command before using the hide one!");
            else {
                for (Player pl : Bukkit.getServer().getOnlinePlayers()) p.showPlayer(plugin, pl);
                removeHidingIndex(index);
                p.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD +
                        "HidePlayers" + ChatColor.RED + "] " + ChatColor.YELLOW + "You can see all players again!");
            }
        }

        else sender.sendMessage("This command can't be executed by the console!");

        return true;
    }

    public void removeHidingIndex(int index)
    {
        Player[] newArray = new Player[plugin.senders.length - 1];
        for (int i = 0; i < index; i++) newArray[i] = plugin.senders[i];
        plugin.senders = newArray;
    }
}
