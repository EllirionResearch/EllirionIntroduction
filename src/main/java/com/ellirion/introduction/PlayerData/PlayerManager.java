package com.ellirion.introduction.PlayerData;

import com.ellirion.introduction.groundWars.Race;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerManager {
    private static HashMap<UUID ,PlayerData> players = new HashMap<>();

    public PlayerManager (){}

    public static boolean newPlayer(Player p, Race r, String rank, int Cash){

        return true;
    }
}
