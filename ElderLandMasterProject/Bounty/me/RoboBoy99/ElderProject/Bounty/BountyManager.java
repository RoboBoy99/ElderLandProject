package me.RoboBoy99.ElderProject.Bounty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class BountyManager {

	public Map<UUID, Bounty> Bounty;
	public List<ItemStack> g;
	
	public BountyManager() {
		Bounty = new HashMap<>();
		g = new ArrayList<>();
	}

	
	public void CreateBounty(Player pl, Player Target, double Bid) {
		UUID uuid = pl.getUniqueId(); 
		if(!Bounty.containsKey(uuid)) {
			PlacedBounty(pl, Target, Bid);
		}

	}
	
	public void PlacedBounty(Player pl, Player Target, double Bid) {
		UUID uuid = pl.getUniqueId(); 
		UUID Targetuuid = Target.getUniqueId();
		Bounty.put(uuid, new Bounty(Bid, uuid, Targetuuid));
		ItemStack newBounty = new ItemStack(Material.MAP);
		ItemMeta BountyM = newBounty.getItemMeta();
		BountyM.setDisplayName(ChatColor.GOLD + "Bounty Info:");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Bidder: " + ChatColor.GREEN + pl.getDisplayName());
		lore.add(ChatColor.GRAY + "Target: " + ChatColor.RED + Target.getDisplayName());
		lore.add(ChatColor.GRAY + "Reward: " + ChatColor.GOLD + Bid);
		BountyM.setLore(lore);
		newBounty.setItemMeta(BountyM);
		g.add(newBounty);
		Bukkit.broadcastMessage(pl.getName() + " Put a bounty on " + ChatColor.RED + Target.getName() + ChatColor.GOLD + " " + Bid);
	}
}
