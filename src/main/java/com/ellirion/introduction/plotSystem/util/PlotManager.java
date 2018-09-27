package com.ellirion.introduction.plotSystem.util;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import com.ellirion.introduction.model.Point;
import com.ellirion.introduction.plotSystem.model.Plot;

import java.util.HashMap;

public class PlotManager {

    private static int plotSize;

    private static final HashMap<String, Plot> SAVED_PLOTS = new HashMap<>();

    public static HashMap<String, Plot> getSavedPlots() {
        return SAVED_PLOTS;
    }

    public boolean CreatePlots(World world, int plotSize, int mapRadius, int centerX, int centerZ) {
        int lowestBlock = 0;
        int highestBlock = 256;
        int chunkSize = 16;

        this.plotSize = plotSize;

        for(int startCountX = mapRadius * -1 + centerX; startCountX < mapRadius + centerX; startCountX++) {
            for(int startCountZ = mapRadius * -1 + centerZ; startCountZ < mapRadius + centerZ; startCountZ++) {

                String name = Integer.toString(startCountX) + " , " + Integer.toString(startCountZ);

                int currentX = startCountX * this.plotSize;
                int currentZ = startCountZ * this.plotSize;

                Point lowerPoint = new Point(currentX, lowestBlock, currentZ);
                Point highestPoint = new Point(currentX + this.plotSize -1, highestBlock, currentZ + this.plotSize -1);

                try {
                    SAVED_PLOTS.put(name, new Plot(name, lowerPoint, highestPoint, this.plotSize, world));
                } catch(Exception e) {
                    return  false;
                }
            }

        }
        return true;
    }

    public static Plot getPlotFromLocation(Location l)
    {
        int x = l.getBlockX();
        int z = l.getBlockZ();

        int plotCordX = Math.floorDiv(x, plotSize);
        int plotCordZ = Math.floorDiv(z, plotSize);

        String name = plotCordX + " , " + plotCordZ;
        return SAVED_PLOTS.get(name);
    }
}
