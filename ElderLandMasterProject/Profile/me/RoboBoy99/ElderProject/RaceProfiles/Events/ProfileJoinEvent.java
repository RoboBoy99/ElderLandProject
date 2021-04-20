package me.RoboBoy99.ElderProject.RaceProfiles.Events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import me.RoboBoy99.ElderProject.RaceProfiles.gprofileManager;
import me.RoboBoy99.ElderProject.RaceProfiles.Gui.Gui;

public class ProfileJoinEvent implements Listener {

	ProfilesManager pm = ElderProject.getInstance().Pm;
	gprofileManager gp = ElderProject.getInstance().gp;
    
	@EventHandler
	public void onJoin(PlayerJoinEvent e)  {
		Player pl = (Player) e.getPlayer();
		if(!pm.Profile.containsKey(pl.getUniqueId())) {
			Gui.ChooseRace(pl);
			gp.create(pl.getUniqueId(), "", "");
			
		}
		
	}
}
