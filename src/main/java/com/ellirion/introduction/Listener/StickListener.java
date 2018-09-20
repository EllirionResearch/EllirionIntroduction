package com.ellirion.introduction.Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class StickListener implements Listener {

    @EventHandler
    public void onPlayerInteractWithStick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        if(!(mainHandItem.getType() == Material.STICK)){
            return;
        }

        Location lookingLocation = player.getTargetBlock(null, 35565).getLocation();

        player.teleport(lookingLocation);

        return;
    }
}
