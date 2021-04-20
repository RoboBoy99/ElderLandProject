package me.RoboBoy99.ElderProject.Housing.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.RoboBoy99.ElderProject.Housing.Gui.HousingGui;
import net.md_5.bungee.api.ChatColor;

public class ClickEvent implements Listener {
	
	@EventHandler
	public void onGuiBounty(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Housing Gui")) 
		{
			if(e.getSlot() == 12) {
				HousingGui.Gui(player);
			}
			e.setCancelled(true);
		}
	}
}
