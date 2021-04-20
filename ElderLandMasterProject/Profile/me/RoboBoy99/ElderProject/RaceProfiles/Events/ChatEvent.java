package me.RoboBoy99.ElderProject.RaceProfiles.Events;

import java.util.UUID;	

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import net.md_5.bungee.api.ChatColor;

public class ChatEvent implements Listener {

	String clanName;
	String role;
	
	@EventHandler
    public void playerChat(AsyncPlayerChatEvent e)
    {
        ProfilesManager pm = ElderProject.getInstance().Pm;
       // ClansManager cm = ElderProject.getInstance().Cm;
		Player player = e.getPlayer();
		UUID uuid = player.getUniqueId();
		//String getClan = cm.Clans(clanName).Role().getOrDefault(uuid, role);
		//String clanFormat = ChatColor.GRAY + "[" + cm.Clans.get(getClan) + ChatColor.GRAY + "] " + ChatColor.RESET + "%1$s: %2$s";
		String LevelFormat = ChatColor.GRAY + " [" + pm.Profile.get(uuid).getCurrentLevel() + ChatColor.GRAY + "] " + ChatColor.RESET + "%1$s: %2$s";
		if(pm.Profile.containsKey(uuid))
		{
			if(pm.Profile.get(uuid).ShowLvl()) {
				e.setFormat(LevelFormat);
			} else {
				e.setFormat("");
			} 
			
			if(pm.Profile.get(uuid).ShowClanInfo()) {
				if(pm.Profile.get(uuid).getRace() == "Humans") {
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.AQUA + "Humans" + ChatColor.GRAY + "]" + player.getName());
				} else if(pm.Profile.get(uuid).getRace() == "Elves") {
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.GREEN + "Elves" + ChatColor.GRAY + "]" + player.getName());
				} else if(pm.Profile.get(uuid).getRace() == "Orcs") {
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Orcs" + ChatColor.GRAY + "]" + player.getName());
				} else if(pm.Profile.get(uuid).getRace() == "Dwarves"){
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.YELLOW + "Dwarves" + ChatColor.GRAY + "]" + player.getName());
				}
			}
			
			if(pm.Profile.get(uuid).ShowClanInfo() && pm.Profile.get(uuid).ShowLvl()) {
				if(pm.Profile.get(uuid).getRace() == "Humans") {
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.AQUA + "Humans" + ChatColor.GRAY + "]" + LevelFormat);
				} else if(pm.Profile.get(uuid).getRace() == "Elves") {
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.GREEN + "Elves" + ChatColor.GRAY + "]" + LevelFormat);
				} else if(pm.Profile.get(uuid).getRace() == "Orcs") {
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Orcs" + ChatColor.GRAY + "]" + LevelFormat);
				} else if(pm.Profile.get(uuid).getRace() == "Dwarves"){
					e.setFormat(ChatColor.GRAY + "[" + ChatColor.YELLOW + "Dwarves" + ChatColor.GRAY + "]" + LevelFormat );
				}		
			}
			
			//if(cm.Clans.containsKey(getClan)) {
				//if(pm.Profile.get(uuid).ShowClanInfo()) {
				//	e.setFormat(clanFormat);
				//}
			//}
			return;
		}
    }
}
