package com.ellirion.introduction.plotSystem.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import com.ellirion.introduction.plotSystem.model.Plot;

public class PlotChangeEvent extends Event
{
    private static HandlerList hm = new HandlerList();
    private final Player player;
    private final Plot plotFrom;
    private final Plot plotTo;

    public PlotChangeEvent(Player player, Plot plotFrom, Plot plotTo) { this.player = player;
        this.plotFrom = plotFrom;
        this.plotTo = plotTo;
    }

    public Player getPlayer() {
        return player;
    }

    public Plot getPlotFrom() {
        return plotFrom;
    }

    public Plot getPlotTo() {
        return plotTo;
    }

    public HandlerList getHandlers()
    {
        return hm;
    }

    public static HandlerList getHandlerList() {
        return hm;
    }
}