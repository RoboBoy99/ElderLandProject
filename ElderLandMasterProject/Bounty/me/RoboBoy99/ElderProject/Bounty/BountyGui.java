package me.RoboBoy99.ElderProject.Bounty;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RoboBoy99.ElderProject.ElderProject;
import net.md_5.bungee.api.ChatColor;

public class BountyGui {

	
	public static void Gui(Player pl) {
		
		Inventory Bounty = Bukkit.createInventory(pl, 27, ChatColor.GOLD + "Bounty");
		
		ItemStack PlaceABounty = new ItemStack(Material.GOLD_INGOT);
		ItemMeta PlaceABountyM = PlaceABounty.getItemMeta();
		PlaceABountyM.setDisplayName(ChatColor.GOLD + "Place a Bounty");
		PlaceABounty.setItemMeta(PlaceABountyM);
		Bounty.setItem(14, PlaceABounty);
		
		ItemStack CheckBounties = new ItemStack(Material.MAP);
		ItemMeta CheckBountiesM = CheckBounties.getItemMeta();
		CheckBountiesM.setDisplayName(ChatColor.GREEN + "Check Bounties");
		CheckBounties.setItemMeta(CheckBountiesM);
		Bounty.setItem(12, CheckBounties);
		pl.openInventory(Bounty);
	}
	
	
	public static void BountyList(Player pl) {
		Inventory Bounty = Bukkit.createInventory(pl, 27, ChatColor.DARK_GREEN + "All Bounties");
		
		pl.openInventory(Bounty);
		for(ItemStack f : ElderProject.getInstance().Bm.g) {
			Bounty.addItem(f);
			
		}
		
	}
}
