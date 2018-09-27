package com.ellirion.introduction.plotSystem.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.ellirion.introduction.plotSystem.model.Plot;
import com.ellirion.introduction.plotSystem.util.PlotManager;

public class GetPlotCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You need to be a player to use this command.");
            return true;
        }

        Player player = (Player) commandSender;

        Plot plot = PlotManager.getPlotFromLocation(player.getLocation());

        player.sendMessage("Name: " + plot.name );

        player.sendMessage("Size: " + plot.plotSize );

        player.sendMessage("Lower Corner: " + plot.lowestCorner );

        player.sendMessage("Highest Corner: " + plot.highestCorner );

        player.sendMessage("World: " + plot.world );


        return true;
    }
}