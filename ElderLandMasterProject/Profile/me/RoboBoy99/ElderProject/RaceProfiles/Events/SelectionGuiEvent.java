package me.RoboBoy99.ElderProject.RaceProfiles.Events;

import java.io.IOException;	
import java.util.UUID;

import org.bukkit.Material;	
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import me.RoboBoy99.ElderProject.RaceProfiles.gprofileManager;
import me.RoboBoy99.ElderProject.RaceProfiles.Gui.Gui;
import net.md_5.bungee.api.ChatColor;

public class SelectionGuiEvent implements Listener {

	ProfilesManager pm = ElderProject.getInstance().Pm;
	gprofileManager gp = ElderProject.getInstance().gp;
	
	@EventHandler
	public void onMenuClick(InventoryClickEvent e) throws IOException 
	{
		Player player = (Player) e.getWhoClicked();
		UUID pl = player.getUniqueId();
		gprofileManager gp = ElderProject.getInstance().gp;
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Choose Your Race?"))
		{
			if(e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
				
				if(e.getSlot() == 10) {
					 Gui.ChooseClass(player);
					 gp.Profile.get(pl).setRace("Orcs");
				}
				
				if(e.getSlot() == 12) {
					 Gui.ChooseClass(player);
					 gp.Profile.get(pl).setRace("Humans");
				}
				
				if(e.getSlot() == 14) {
					 Gui.ChooseClass(player);
					 gp.Profile.get(pl).setRace("Elves");
				}
				
				if(e.getSlot() == 16) {
					 Gui.ChooseClass(player);
					 gp.Profile.get(pl).setRace("Dwarves");
				}
			}
			e.setCancelled(true);
		}
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "Choose Your class")) {	
			if(e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
				
				if(e.getSlot() == 10) {
				
					gp.Profile.get(pl).setClass("Class1");
					Gui.LostChoosenGui(player);
				}
				
				if(e.getSlot() == 12) {
					gp.Profile.get(pl).setClass("Class2");
					Gui.LostChoosenGui(player);
				}
				
				if(e.getSlot() == 14) {
					gp.Profile.get(pl).setClass("Class3");
					Gui.LostChoosenGui(player);
				}
				
				if(e.getSlot() == 16) {
					gp.Profile.get(pl).setClass("Class4");
					Gui.LostChoosenGui(player);
				}
			}	
			if(e.getCurrentItem().getType() == Material.RED_CONCRETE) {
					Gui.ChooseRace(player);
			}
			e.setCancelled(true);
		}
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Confirmation menu")) {
			
			if(e.getCurrentItem().getType() == Material.GREEN_CONCRETE) {
							
				pm.CreateProfile(player, gp.Profile.get(player.getUniqueId()).getRace(), gp.Profile.get(player.getUniqueId()).getPClass());
			    player.closeInventory();
			    player.sendMessage(ChatColor.DARK_PURPLE + "ElderLands >> " + ChatColor.GRAY + "your profile has been created successfully");
			}
			
			if(e.getCurrentItem().getType() == Material.RED_CONCRETE) {
				Gui.ChooseClass(player);
			}
			e.setCancelled(true);
		}
		
		
	    //int slot = e.getSlot();
		//ItemStack item = e.getWhoClicked().getInventory().getItem(slot);
		//player.sendMessage(item.getItemMeta().getDisplayName());

	}
}
