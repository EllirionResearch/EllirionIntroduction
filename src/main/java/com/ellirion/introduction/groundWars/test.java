package com.ellirion.introduction.groundWars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.scoreboard.Team;

public class test {
//    private ScoreboardManager manager = Bukkit.getScoreboardManager();

    protected static Scoreboard scoreboard = TeamManager.getScoreboard();

    protected static Objective obj = scoreboard.registerNewObjective("Servername", "dummy");

    protected static Team redTeam;// = scoreboard.registerNewTeam("Red");
    protected static Team blueTeam;// = scoreboard.registerNewTeam("Blue");

    protected static Team onlineCounter = scoreboard.registerNewTeam("onlineCounter");

    protected static Score onlineName;


    public test(){
        if(TeamManager.createTeam("Red", ChatColor.RED, ChatColor.DARK_RED)){
            redTeam = TeamManager.getTeam("Red");
        }
        if (TeamManager.createTeam("Blue", ChatColor.BLUE, ChatColor.DARK_BLUE)){
            blueTeam = TeamManager.getTeam("Blue");
        }

        redTeam.setColor(ChatColor.RED);
        redTeam.setDisplayName("Red Team");
        redTeam.setAllowFriendlyFire(false);

        blueTeam.setColor(ChatColor.BLUE);
        blueTeam.setDisplayName("Blue Team");
        blueTeam.setAllowFriendlyFire(true);

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("Test Server ");

        onlineName = obj.getScore(ChatColor.GRAY + "» Online");
        onlineName.setScore(15);

        onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE + "");

        if(Bukkit.getOnlinePlayers().size() == 0) {
            onlineCounter.setPrefix(ChatColor.DARK_RED + "" + "0" + ChatColor.RED + "/" + "" + ChatColor.DARK_RED + Bukkit.getServer().getMaxPlayers());
        }else{
            onlineCounter.setPrefix(String.valueOf(ChatColor.DARK_RED + "" + Bukkit.getOnlinePlayers().size() + "" + ChatColor.RED + "/" + "" + ChatColor.DARK_RED + "" + Bukkit.getServer().getMaxPlayers()));
        }

        obj.getScore(ChatColor.BLACK + "" + ChatColor.WHITE + "").setScore(14);
    }

    public void joinRedTeam (Player p){
        String playername = p.getName();
//        redTeam.addPlayer(p);
        redTeam.addEntry(playername);
        setPlayerScoreboard(p);
        p.getServer().broadcastMessage("player " + playername + " joined team red");
    }

    public void leaveRedTeam (Player p){
        String playername = p.getName();
        if(redTeam.hasEntry(playername)){
            redTeam.removeEntry(playername);
//            redTeam.removePlayer(p);
            p.getServer().broadcastMessage("player " + playername + " left the red team");
        }else{
            p.sendMessage("you are not in the red team");
        }
    }

    public void joinBlueTeam (Player p){
        String playername = p.getName();
        blueTeam.addEntry(playername);
        setPlayerScoreboard(p);
//        blueTeam.addPlayer(p);
        p.getServer().broadcastMessage("player " + playername + " joined team blue");
    }

    public void leaveBlueTeam (Player p){
        String playername = p.getName();
        if(blueTeam.hasEntry(playername)){
             blueTeam.removeEntry(playername);
//             blueTeam.removePlayer(p);
            p.getServer().broadcastMessage("player " + playername + " left the blue team");
        }else{
            p.sendMessage("you are not in the blue team");
        }
    }

    private void setPlayerScoreboard(Player p){
        p.setScoreboard(scoreboard);
    }
}
