package me.RoboBoy99.ElderProject.Housing.Gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.Housing.Housing;
import net.md_5.bungee.api.ChatColor;

public class HousingGui {

	public static void Gui(Player player) {
		Inventory hb = Bukkit.createInventory(player, 18 ,ChatColor.GREEN + "Housing");
		for(Housing h : ElderProject.getInstance().Hm.Housing) {
			ItemStack a = new ItemStack(Material.PLAYER_HEAD);
			ItemMeta am = a.getItemMeta();
			am.setDisplayName(ChatColor.GRAY + "House");
			List<String> lore = new ArrayList<>();
			lore.add(ChatColor.DARK_GRAY + "-Owner: " + ChatColor.AQUA + Bukkit.getOfflinePlayer(h.getOwner()).getName());
			lore.add(ChatColor.DARK_GRAY + "-Des: " + ChatColor.GREEN + h.getDesc());
			lore.add(ChatColor.DARK_GRAY + "-Price: " + ChatColor.GOLD + h.getAmount());
			am.setLore(lore);
			a.setItemMeta(am);
			hb.addItem(a);
		}
		player.openInventory(hb);
	}
	
	public static void FirstGui(Player player) {
		Inventory hb = Bukkit.createInventory(player, 27 ,ChatColor.GREEN + "Housing Gui");
		ItemStack a = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta am = a.getItemMeta();
		am.setDisplayName(ChatColor.GREEN + "Check Available Houses");
		a.setItemMeta(am);
		hb.setItem(12, a);
		
		
		ItemStack b = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta bm = b.getItemMeta();
		bm.setDisplayName(ChatColor.GOLD + "You're House");
		b.setItemMeta(bm);
		hb.setItem(14, b);
		player.openInventory(hb);
	}	
	
	public static void HouseGui(Player player) {
		Inventory hb = Bukkit.createInventory(player, 27 ,ChatColor.GREEN + "Housing Gui");
		ItemStack a = new ItemStack(Material.HOPPER);
		ItemMeta am = a.getItemMeta();
		am.setDisplayName(ChatColor.GREEN + "Settings");
		a.setItemMeta(am);
		hb.setItem(12, a);
	}
	
	
	
	
}
