package me.RoboBoy99.ElderProject.MainClans.Cmd;


import java.util.Date;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.MainClans.ClansManager;
import net.md_5.bungee.api.ChatColor;
	
public class ClanCmd implements CommandExecutor{

	Date joinDate = new Date();
	Date leaveDate = new Date();

	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       if(!cmd.getName().equalsIgnoreCase("Clan"))
           return false;
       if (!(sender instanceof Player))
           return false;

       ClansManager cm = ElderProject.getInstance().Cm;
      // ClaimsManager Claim = ElderProject.getInstance().ClaimsMa;
       Player player = (Player) sender;
       
       if(args[0].equalsIgnoreCase("Create")) {
    	   cm.HumansCreate(player);
    	   player.sendMessage(ChatColor.GREEN +  "Created");
   
    	   
    	 //  Claims claim = new Claims(player.getUniqueId(), new ArrayList<UUID>(), player.getLocation().getChunk(), "Humans");
   		  // Claim.addClaim(claim); 
    	   return true;
       }
    	   
    	   
      if(args[0].equalsIgnoreCase("Check")) {
    	  	
    	 // String h = args[2];
          cm.CheckClan(args[1], player);
          return true;
    	   
      }
	return false;
	}
}
