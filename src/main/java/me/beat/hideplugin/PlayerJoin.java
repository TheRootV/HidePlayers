package me.beat.hideplugin;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    public static Hideplugin plugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player pl = event.getPlayer();
        for (int i = 0; i < plugin.senders.length; i++)
        {
            Player p = plugin.senders[i];
            p.hidePlayer(plugin, pl);
        }
    }
}
