package me.RoboBoy99.ElderProject.MainClans;

import java.util.HashMap;	
import java.util.Map;
import java.util.UUID;


import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class ClansManager {

	
	public Map<String, Clans> Clans;
	
	public ClansManager(){
		Clans = new HashMap<>();
	}
	

    
	public void HumansCreate(Player player) {
		Clans.put("Humans", new Clans(null, 0, 0, player.getLocation().getChunk()));
		Clans.get("Humans").Role.put(player.getUniqueId(), "King");
	}
	@SuppressWarnings("unlikely-arg-type")
	public void Setking(UUID King, String h) {
		String k = "King"; 
		Clans.get(h).King = King;
		Clans.get(h).Role.remove(k);
		Clans.get(h).Role.put(King, k);
	}
	
	
	public boolean exist(String h) {
		return Clans.containsKey(h);
	}
	
	
	public void CheckClan(String h, Player pl) {
		if(!exist(h)) 
			return;
			
		pl.sendMessage(ChatColor.DARK_GRAY + "-==== "+ ChatColor.GOLD + h + " Clans Info " + ChatColor.DARK_GRAY + "====-");
		if(Clans.get(h).getKing() == null) {
			pl.sendMessage(ChatColor.GRAY + "Current King: " + ChatColor.RED + "none");
			pl.sendMessage(ChatColor.GRAY + "Clan " + "balance " + ChatColor.GOLD + Clans.get(h).getBalance());
			pl.sendMessage(ChatColor.GRAY + "Roles: " + ChatColor.RED + Clans.get(h).Role.get(pl.getUniqueId()));
			
		} else {
			pl.sendMessage(ChatColor.GRAY + "Current King " + ChatColor.AQUA + Clans.get(h).getKing());
			pl.sendMessage(ChatColor.GRAY + "Clan " + "balance " + ChatColor.GOLD +Clans.get(h).getBalance());
		}
	}
	
	
}
