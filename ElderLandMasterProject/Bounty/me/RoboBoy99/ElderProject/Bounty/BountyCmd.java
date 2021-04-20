package me.RoboBoy99.ElderProject.Bounty;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.ElderProject.ElderProject;



public class BountyCmd implements CommandExecutor{
	

	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	       if(!cmd.getName().equalsIgnoreCase("Bounty"))
	           return false;
	       if (!(sender instanceof Player))
	           return false;

	       BountyManager bm = ElderProject.getInstance().Bm;
	       Player player = (Player) sender;
	       if(args.length == 0) {
	    	   BountyGui.Gui(player);
	    	   return true;
	       }
	       if(args[0].equalsIgnoreCase("create")) {
	    	   Player target = Bukkit.getPlayer(args[1]);
	    	   double d = Integer.parseInt(args[2]);
	    	   bm.CreateBounty(player, target, d);
	    	   return true;
	       }
		return false;
	 }
}
