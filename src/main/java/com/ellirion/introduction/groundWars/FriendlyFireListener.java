package com.ellirion.introduction.groundWars;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.scoreboard.Team;

import java.util.Set;

import static com.ellirion.introduction.groundWars.test.blueTeam;
import static com.ellirion.introduction.groundWars.test.redTeam;

public class FriendlyFireListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity damaged = e.getEntity();



        System.out.println("EVENT FIRED");
        if (damaged instanceof Player && damager instanceof Player) {
            Player pdamaged = (Player) damaged;
            Player pdamager = (Player) damager;

            System.out.println("EVENT FIRED");
            Race damagedPlayerRace = RaceManager.getPlayerRace(pdamaged);
            Race damagerPlayerRace = RaceManager.getPlayerRace(pdamager);
            if(damagedPlayerRace == damagerPlayerRace){
                e.setCancelled(true);
                pdamaged.getServer().broadcastMessage("same team " + damagedPlayerRace.getRaceName());
            }
//            if (playerInTeam(pdamaged, redTeam) && playerInTeam(pdamager, redTeam)){
//                e.setCancelled(true);
//                System.out.println("same team RED");
//            }
//
//            if (playerInTeam(pdamaged, blueTeam) && playerInTeam(pdamager, blueTeam)){
//                e.setCancelled(true);
//                System.out.println("same team BLUE");
//            }

        }
    }

//    private boolean playerInTeam(Player p, Team t){
//        return t.hasEntry(p.getName());
//    }
}
