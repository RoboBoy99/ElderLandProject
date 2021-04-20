package me.RoboBoy99.ElderProject.Bounty.Events;

	
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.RoboBoy99.ElderProject.Bounty.BountyGui;
import net.md_5.bungee.api.ChatColor;

public class OnInventoryEvent implements Listener  {

	
	@EventHandler
	public void onGuiBounty(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Bounty")) 
		{
			if(e.getCurrentItem().getType() == Material.MAP) {
				BountyGui.BountyList(player);
			}
			e.setCancelled(true);
		}
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "All Bounties")){
			
			e.setCancelled(true);
		}
	}
}
