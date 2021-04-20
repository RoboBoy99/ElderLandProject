package me.RoboBoy99.ElderProject.RaceProfiles.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import me.RoboBoy99.ElderProject.RaceProfiles.Gui.Gui;

public class ProfileMovements implements Listener {

	ProfilesManager pm = ElderProject.getInstance().Pm;
	
	@EventHandler
	public void ProfileMovement( AsyncPlayerChatEvent e) {
		Player pl = e.getPlayer();
		if(!pm.Profile.containsKey(pl.getUniqueId())) {
			Gui.ChooseRace(pl);
		}
	}

}
