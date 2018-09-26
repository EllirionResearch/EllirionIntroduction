package com.ellirion.introduction.groundWars;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RaceManager {

    private HashMap<String, Race> races;
    private Set<ChatColor> usedColors;

    public RaceManager(String DefaultRace){
        races = new HashMap<>();
        Race r = new Race(DefaultRace, ChatColor.DARK_GRAY);
        races.put(r.getRaceName(), r);
        usedColors = new HashSet<>();
        usedColors.add(ChatColor.DARK_GRAY);
    }

    public boolean addRace(String name, ChatColor color){
        if(usedColors.contains(color) || raceExists(name)){
            return false;
        }
        Race r = new Race(name, color);
        usedColors.add(color);
        return true;
    }

    public boolean ChangeRaceName(String name, String newName){
        if(raceExists(newName)){
            return false;
        }
        Race r = races.remove(name);
        r.setRaceName(newName);
        races.putIfAbsent(newName, r);
        return true;
    }

    public Set<String> getRaceNames(){
        return races.keySet();
    }

    public boolean addPlayerToRace(Player p, String raceName){
        if(!raceExists(raceName) || hasRace(p)){
            return false;
        }

        Race r = races.get(raceName);
        r.addPlayer(p.getName());
        p.setDisplayName(r.getTeamColor() + "[" + raceName + "] " + ChatColor.RESET+ p.getName());
        return true;
    }

    public boolean hasRace(Player p){
        for(Race r : races.values()) {
            if (r.hasPlayer(p.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean raceExists(String raceName){
        return  races.containsKey(raceName);
    }
}
