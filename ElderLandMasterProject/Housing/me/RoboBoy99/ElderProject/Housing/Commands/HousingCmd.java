package me.RoboBoy99.ElderProject.Housing.Commands;

import java.util.ArrayList;		
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.Claims.ClaimsManager;
import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.Housing.Housing;
import me.RoboBoy99.ElderProject.Housing.HousingManager;
import me.RoboBoy99.ElderProject.Housing.Gui.HousingGui;
import net.md_5.bungee.api.ChatColor;

public class HousingCmd implements CommandExecutor {

	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	       if(!cmd.getName().equalsIgnoreCase("Housing"))
	           return false;
	       if (!(sender instanceof Player))
	           return false;	       
	       HousingManager hm = ElderProject.getInstance().Hm;
	       ClaimsManager Claim = ElderProject.getInstance().ClaimsMa;
	       Player player = (Player) sender;
	       
	       if(args.length == 0) {
	    	   HousingGui.FirstGui(player);
	    	   return true;
	       }
	       
	       if(args[0].equalsIgnoreCase("claim")) {
		      //if(Claim.isClaimed(player.getLocation().getChunk())) {
		         //  player.sendMessage(ChatColor.RED + "Already Claimed");
		        //  return false;
		       }
		     //   
		      // UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000000");
	    	   Housing house = new Housing(player.getUniqueId(), new ArrayList<UUID>(), null, true, 0.0, player.getLocation().getChunk(), "test");
	    	   hm.CreateHouse(house);
	    	   int x =Integer.parseInt(args[1]); 
	    	   int z =Integer.parseInt(args[2]); 
	   		   Claim.addClaim(x, z, player); 
		       player.sendMessage(ChatColor.GREEN + "Chunk is claimed");

		     //   for (Location corner : ChunkUtils.getChunkCorners(house.getChunk(), z, z)) {	
		         //       corner.getBlock().setType(Material.GOLD_BLOCK);
		     //   }
		       
	       

	       if(args[0].equalsIgnoreCase("check")) {
	    	 //  int x =Integer.parseInt(args[1]); 
	    	 //  int z =Integer.parseInt(args[2]); 
             ////  Claim.getClaimAt(x, z, player);
	       }
               
               

			return false;
	}

}
