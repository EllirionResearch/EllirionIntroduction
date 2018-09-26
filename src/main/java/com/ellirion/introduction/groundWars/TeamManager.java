package com.ellirion.introduction.groundWars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TeamManager {

    private static Map<String, Team> Teams = new HashMap<>();
    private static Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

    public static Scoreboard getScoreboard(){
        return scoreboard;
    }

    public static boolean createTeam(String teamName, ChatColor color1, ChatColor color2){
        if(Teams.containsKey(teamName)){
            return false;
        }

        for(Team t : Teams.values()){
            if(t.hasEntry(color1 + "" + color2+ "")){
                return false;
            }
        }

        Team t = scoreboard.registerNewTeam(teamName);
        t.addEntry(color1 + "" + color2 + "");
        Teams.putIfAbsent(teamName, t);

        return true;
    }

    public static Team getPlayerTeam(Player player) {
        for(Team t : Teams.values()){
            if(t.hasEntry(player.getName())){
                return t;
            }
        }
        return null;
    }

    public static Team getTeam(String teamName){
        if(Teams.containsKey(teamName)){
            return Teams.get(teamName);
        }
        return null;
    }
}
