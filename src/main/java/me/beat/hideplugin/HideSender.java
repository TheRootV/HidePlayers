package me.beat.hideplugin;

import org.bukkit.entity.Player;

public class HideSender {
    public Player sender;
    public Player[] hideList;

    public HideSender(Player p)
    {
        this.sender = p;
    }

    public HideSender()
    {

    }
}
