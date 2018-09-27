package com.ellirion.introduction.Resources.Listener;

import com.ellirion.introduction.EllirionIntroduction;
import com.ellirion.introduction.Resources.Tools;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class playerInterActEventListener implements Listener {

    @EventHandler
    public void onPlayerInteractWithTool(BlockBreakEvent e){

        Player player = e.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        if(Tools.pickaxeMaterials.contains(mainHandItem.getType())){
            e.setCancelled(true);
        }
    }
}
