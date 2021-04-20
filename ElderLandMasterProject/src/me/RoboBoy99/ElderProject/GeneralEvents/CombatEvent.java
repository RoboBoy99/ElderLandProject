package me.RoboBoy99.ElderProject.GeneralEvents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import net.md_5.bungee.api.ChatColor;

public class CombatEvent implements Listener {

	ProfilesManager pm = ElderProject.getInstance().Pm;
	@EventHandler
	 public void entityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        Player damager = (Player) e.getDamager();
        Entity target = e.getEntity();
        double damage = pm.Profile.get(damager.getUniqueId()).getPower();

        if (damager instanceof Player) {
            e.setDamage(damage);
            damager.sendMessage(ChatColor.GOLD + "You deal " + (int)damage + " damage to " + target.getName() + ChatColor.GOLD + ".");
       }	
    }
}
