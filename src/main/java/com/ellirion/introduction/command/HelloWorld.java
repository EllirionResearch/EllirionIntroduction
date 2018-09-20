package com.ellirion.introduction.command;

import org.bukkit.EntityEffect;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class HelloWorld implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String playerName;
        Player player = null;

        // set the server to broadcast to.
        Server server = commandSender.getServer();

        // if it isn't aplayer then the server is broadcasting.
        // else get the player name.
        if (!(commandSender instanceof Player)){
            playerName = "server";
        }else{
            player = (Player) commandSender;


            playerName = player.getDisplayName();
        }

        String message = "player " + playerName + " says hello world.";
        // check if the commandsender send any more strings with the command.
        if(strings.length!=0){
            message += " " + playerName + " also says the following: ";

            for(int i = 0; i < strings.length; i++){
                message += strings[i] + " ";
            }
        }
        // broadcast the message to the whole server.
        server.broadcastMessage(message);
        return true;
    }
}
