package me.beat.hideplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hideplugin extends JavaPlugin {

    public static Player[] senders = new Player[0];

    @Override
    public void onEnable() {
        HideCommand.plugin = this;
        ShowCommand.plugin = this;
        PlayerJoin.plugin = this;
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginCommand("hide").setExecutor(new HideCommand());
        getServer().getPluginCommand("show").setExecutor(new ShowCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public int playerHidingIndex(Player p)
    {
        int i = 0;
        boolean found = false;
        while (!found && i < this.senders.length)
        {
            found = p == this.senders[i];
            i++;
        }
        return found ? i - 1 : -1;
    }
}
