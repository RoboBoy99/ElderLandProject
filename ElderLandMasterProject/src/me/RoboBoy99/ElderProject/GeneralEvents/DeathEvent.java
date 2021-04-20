package me.RoboBoy99.ElderProject.GeneralEvents;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.md_5.bungee.api.ChatColor;

public class DeathEvent implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player pl = e.getEntity();
        Location location = pl.getLocation().toVector().add(pl.getLocation().getDirection().multiply(2)).toLocation(pl.getWorld());

        final ArmorStand armorS = (ArmorStand) pl.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorS.setVisible(false);
		armorS.setCustomName(ChatColor.RED+ "Here Died " + ChatColor.GREEN + pl.getDisplayName());	
		armorS.setCustomNameVisible(true);
		armorS.setGravity(false);	
		pl.sendMessage(ChatColor.RED + "the msg will dispare in 10 seconds");
        
	}
}
