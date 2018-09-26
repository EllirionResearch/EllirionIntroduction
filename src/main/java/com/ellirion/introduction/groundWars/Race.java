package com.ellirion.introduction.groundWars;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;

public class Race {
    private Set<String> players;
    private String raceName;
    private ChatColor teamColor;

    public Race (String name, ChatColor color){
        players = new HashSet<>();
        raceName = name;
        teamColor = color;
    }

    public boolean addPlayer(String p){
        return players.add(p);
    }

    public boolean removePlayer(String p){
        return players.remove(p);
    }

    public boolean hasPlayer(String)

}
