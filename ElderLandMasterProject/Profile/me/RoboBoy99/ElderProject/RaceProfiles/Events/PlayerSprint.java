package me.RoboBoy99.ElderProject.RaceProfiles.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;

public class PlayerSprint implements Listener {
	
	ProfilesManager pm = ElderProject.getInstance().Pm;
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
	    Player p = event.getPlayer();
	    if (p.isSprinting()) {
	    	//double stamina = ((pm.Profile.get(p.getUniqueId()).getStamina()) - 1);
	    //	p.sendMessage(stamina + "");
	    	//if(stamina <= 0) {
		  //  	p.setSprinting(false);
	    //	}
	    } 
	}
}
