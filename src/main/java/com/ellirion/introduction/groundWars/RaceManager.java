package com.ellirion.introduction.groundWars;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RaceManager {

    private static HashMap<String, Race> races = new HashMap<>();;
    private static Set<ChatColor> usedColors = new HashSet<>();

    public RaceManager(String DefaultRace){

        Race r = new Race(DefaultRace, ChatColor.DARK_GRAY);
        races.put(r.getRaceName(), r);

        usedColors.add(ChatColor.DARK_GRAY);
    }

    public static boolean addRace(String name, ChatColor color){
        if(usedColors.contains(color) || raceExists(name)){
            return false;
        }
        Race r = new Race(name, color);
        races.putIfAbsent(name, r);
        usedColors.add(color);
        return true;
    }

    public static boolean ChangeRaceName(String name, String newName){
        if(raceExists(newName)){
            return false;
        }
        Race r = races.remove(name);
        r.setRaceName(newName);
        races.putIfAbsent(newName, r);
        return true;
    }

    public static Set<String> getRaceNames(){
        return races.keySet();
    }

    public static boolean addPlayerToRace(Player p, String raceName){
        if(!raceExists(raceName) || hasRace(p)){
            return false;
        }

        Race r = races.get(raceName);
        r.addPlayer(p.getUniqueId());
        p.setDisplayName(r.getTeamColor() + "[" + raceName + "] " + ChatColor.RESET+ p.getName());
        return true;
    }

    public static boolean hasRace(Player p){
        for(Race r : races.values()) {
            if (r.hasPlayer(p.getUniqueId())) {
                return true;
            }
        }
        return false;
    }

    public static boolean raceExists(String raceName){
        return  races.containsKey(raceName);
    }

    public static Race getPlayerRace(Player p){
        for(Race r : races.values()){
            if(r.hasPlayer(p.getUniqueId())){
                return r;
            }
        }
        return null;
    }

    public static boolean isColerInUse(ChatColor color){
        return usedColors.contains(color);
    }
}
