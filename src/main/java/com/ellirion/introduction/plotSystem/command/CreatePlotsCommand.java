package com.ellirion.introduction.plotSystem.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.ellirion.introduction.plotSystem.model.Plot;
import com.ellirion.introduction.plotSystem.util.PlotManager;

import java.util.HashMap;
import java.util.Map;

public class CreatePlotsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You need to be a player to use this command.");
            return true;
        }

        Player player = (Player) commandSender;

        // Check if a name was entered
        if (strings.length < 4 || strings.length > 4) {
            player.sendMessage(ChatColor.DARK_RED +
                               "Please give the template a name with the following arguments: <PLOT-SIZE> <MAP-RADIUS> <CENTER-X> <CENTER-Z>");
            return true;
        }
        int plotSize = Integer.parseInt(strings[0]);
        int mapRadius = Integer.parseInt(strings[1]);
        int centerX = Integer.parseInt(strings[2]);
        int centerZ = Integer.parseInt(strings[3]);


        //Check if plotsize is chunksize(16) friendly
        if( plotSize <= 0 ||  plotSize % 16 != 0 ) {
            player.sendMessage(ChatColor.DARK_RED + "Make sure your plot size is not negative.");
            player.sendMessage(ChatColor.DARK_RED + "The plot size needs to be a factor of 16. Like : 16,32,48,64,128");
            return true;
        }

        PlotManager plotManager = new PlotManager();

        if(!plotManager.CreatePlots(player.getWorld(), plotSize, mapRadius, centerX, centerZ)) {
            player.sendMessage(ChatColor.DARK_RED + "Something went wrong with saving the plots.");
        }

        player.sendMessage("Plots are created");

        HashMap<String, Plot> plots = PlotManager.getSavedPlots();

        for(Map.Entry<String, Plot> entry : plots.entrySet()) {
            String key = entry.getKey();
            Plot plot = entry.getValue();
            player.sendMessage(key + " Lower Corner: " + plot.lowestCorner.toString() + " Higher Corner: " + plot.getHighestCorner().toString());
        }

        return true;
    }
}