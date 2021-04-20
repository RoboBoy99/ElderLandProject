package me.RoboBoy99.ElderProject.RaceProfiles.cmds;

import java.io.IOException;		

import org.bukkit.command.Command;		
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import net.md_5.bungee.api.ChatColor;

public class ProfileCmd implements CommandExecutor {

	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("Profile"))
            return false;
        if (!(sender instanceof Player))
            return false;
 
        Player player = (Player) sender;
  
        ProfilesManager pm = ElderProject.getInstance().Pm;
        if(args.length == 0) {

          //  ProfilesManager pm = ElderProject.getInstance().pm;
            pm.ProfileExists(player);
            return true;
        }
        
        if(args[0].equalsIgnoreCase("join")) {
        	try {
				pm.CreateProfile(player, args[1], args[2]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return true;
        }
        
        
        if(args[0].equalsIgnoreCase("check")) {
        	player.sendMessage(ChatColor.GOLD + "Profile >> " + pm.Profile.toString());
        	return true;
        }
		return false;
	}
}
