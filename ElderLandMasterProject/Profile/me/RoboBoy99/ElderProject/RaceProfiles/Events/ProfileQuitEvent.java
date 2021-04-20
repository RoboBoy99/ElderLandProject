package me.RoboBoy99.ElderProject.RaceProfiles.Events;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;


public class ProfileQuitEvent implements Listener {

    
	@EventHandler
	public void onQuit(PlayerQuitEvent e) throws IOException {
		ProfilesManager pm = ElderProject.getInstance().Pm;
		Player player = e.getPlayer();
		if(pm.Profile.containsKey(player.getUniqueId())) {
			ElderProject.getInstance().saveProfile();
		}
		
	}
	
}
