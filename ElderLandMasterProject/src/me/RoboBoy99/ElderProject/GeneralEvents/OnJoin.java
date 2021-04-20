package me.RoboBoy99.ElderProject.GeneralEvents;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;

public class OnJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player pl = (Player) e.getPlayer();
		ProfilesManager pm = ElderProject.getInstance().Pm;
		pm.ProfileExists(pl);
		
	}
}
