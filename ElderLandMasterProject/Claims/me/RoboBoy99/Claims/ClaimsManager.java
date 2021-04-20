package me.RoboBoy99.Claims;

import java.util.HashMap;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class ClaimsManager {

	
	Map<Integer, Map<Integer, Claims>> Claims;
	
	public ClaimsManager() {
		Claims = new HashMap<>();
	}
	

	public Claims getClaimAt(int x, int z, Player player) {
	  if (!Claims.containsKey(x)) {
		  player.sendMessage("no");
	    return null;
	  }
	  player.sendMessage(ChatColor.GREEN + "Owner > " + Bukkit.getPlayer(Claims.get(x).getOrDefault(z, null).getOwner()).getDisplayName());
	  player.sendMessage(ChatColor.AQUA + "Type > " + Claims.get(x).getOrDefault(z, null).getType() + "");
	  player.sendMessage(ChatColor.GOLD + "z > " + Claims.get(x).getOrDefault(z, null).getX());
	  player.sendMessage(ChatColor.GOLD + "x > " + Claims.get(x).getOrDefault(z, null).getZ());
	  return Claims.get(x).getOrDefault(z, null);
	}

	public void addClaim(int x, int z, Player player) {
	  Claims.putIfAbsent(x, new HashMap<Integer, Claims>());
	  Claims.get(x).putIfAbsent(z, new Claims(player.getUniqueId(), null, x, z, "Test"));
	}
	


    
    
    
    
   
    ///Place 4 armor stands and then use a random to choose from these 4 and claim the chunk
	
}
