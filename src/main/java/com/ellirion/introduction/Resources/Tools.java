package com.ellirion.introduction.Resources;



import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static List<Material> pickaxeMaterials = new ArrayList<Material>(){{
        add(Material.DIAMOND_PICKAXE);
        add(Material.GOLD_PICKAXE);
        add(Material.IRON_PICKAXE);
        add(Material.STONE_PICKAXE);
        add(Material.WOOD_PICKAXE);
    }};

    public static List<Material> axeMaterials = new ArrayList<Material>(){{
        add(Material.DIAMOND_AXE);
        add(Material.GOLD_AXE);
        add(Material.IRON_AXE);
        add(Material.STONE_AXE);
        add(Material.WOOD_AXE);
    }};

}
