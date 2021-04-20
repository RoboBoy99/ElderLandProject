package me.RoboBoy99.ElderProject.RaceProfiles.Events;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.RoboBoy99.ElderProject.RaceProfiles.Gui.Gui;
import net.md_5.bungee.api.ChatColor;

public class MainGuiEvent implements Listener {

	@EventHandler
	public void onMenuClick(InventoryClickEvent e) 
	{
		Player player = (Player) e.getWhoClicked();
		//UUID pl = player.getUniqueId();
	//	ProfilesManager pm = ElderProject.getInstance().Pm;
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "ElderLands Menu"))
		{
			if(e.getCurrentItem().getType() == Material.ENDER_CHEST) {
				player.openInventory(player.getEnderChest());
			}
			e.setCancelled(true);
			
			if(e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
				Gui.SettingsGui(player);
			}
			e.setCancelled(true);
		}
	}	
}
