package com.ellirion.introduction.groundWars;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Teamstest implements CommandExecutor {
    private test t = new test();

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        Player p = (Player)commandSender;

        if(label.equalsIgnoreCase("joinRed")){
            t.joinRedTeam(p);
        }else if(label.equalsIgnoreCase("leaveRed")){
            t.leaveRedTeam(p);
        }else if(label.equalsIgnoreCase("joinBlue")){
            t.joinBlueTeam(p);
        }else if(label.equalsIgnoreCase("leaveBlue")){
            t.leaveBlueTeam(p);
        }
        return true;
    }
}
