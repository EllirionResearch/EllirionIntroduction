package com.ellirion.introduction.groundWars;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.ChatColor;

public class Race {
    private Set<UUID> players;
    private String raceName;
    private ChatColor teamColor;

    public Race (String name, ChatColor color){
        players = new HashSet<>();
        raceName = name;
        teamColor = color;
    }

    public boolean addPlayer(UUID p){
        return players.add(p);
    }

    public boolean removePlayer(UUID p){
        return players.remove(p);
    }

    public boolean hasPlayer(UUID p){
        return players.contains(p);
    }

    public String getRaceName() {
        return raceName;
    }

    public ChatColor getTeamColor() {
        return teamColor;
    }

    public void setRaceName(String name){
        raceName = name;
    }
}
