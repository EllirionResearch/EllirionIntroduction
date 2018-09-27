package com.ellirion.introduction.plotSystem.model;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.World;
import com.ellirion.introduction.EllirionIntroduction;
import com.ellirion.introduction.model.Point;
import com.ellirion.introduction.groundWars.Race;

public class Plot {
    public int id;
    public @Getter String name;
    public @Getter int plotSize;
    public @Getter Point lowestCorner;
    public @Getter Point highestCorner;
    public @Getter @Setter Race owner;
    public @Getter World world;


    public Plot(String name, Point lowestCorner, Point highestCorner, int plotSize, World world) {
        this.name = name;
        this.lowestCorner = lowestCorner;
        this.highestCorner = highestCorner;
        this.plotSize = plotSize;
        this.world = world;
    }
}
