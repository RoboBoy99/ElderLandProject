package me.RoboBoy99.ElderProject.RaceProfiles;

import java.io.File;	
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.Gui.Gui;
import net.md_5.bungee.api.ChatColor;

public class ProfilesManager {

	public Map<UUID, Profile> Profile;
	
	public ProfilesManager() {
		Profile = new HashMap<>();
	}	
	

    public void saveProfile(Player p, String race) throws IOException {
        File f = new File(ElderProject.getInstance().getDataFolder().getAbsolutePath(), p.getName() + " Profile" + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("Race", race);
       // c.set("Balance", Token.playerBank.get(p.getUniqueId()));
        c.save(f);
    }

    public void loadProfile(Player p) throws IOException {
        File f = new File(ElderProject.getInstance().getDataFolder().getAbsolutePath(), p.getName() + " Profile" + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        String race = (String) c.get("Race");
        String classs = (String) c.get("Class");
        double Balance = (double) c.get("Balance");
        p.sendMessage(race);
        Profile.put(p.getUniqueId(), new Profile(p.getUniqueId(), race, classs, 0, 0, 0, 0, 0, 0, 0, 10, true, true, true));
        ElderProject.getInstance().playerBank.put(p.getUniqueId(), Balance);
    }
    
	
	public void getProfile(Player pl) {		
		UUID uuid = pl.getUniqueId();
		pl.sendMessage(ChatColor.DARK_GRAY + "-==== "+ ChatColor.GOLD + Bukkit.getPlayer(Profile.get(uuid).getPlayer()).getName() + " Profile " + ChatColor.DARK_GRAY + "====-");
		pl.sendMessage(ChatColor.GRAY + "   - Player Race: " + ChatColor.GREEN + Profile.get(uuid).getRace());
		pl.sendMessage(ChatColor.GRAY + "   - Player Balance: " + ChatColor.GOLD + ElderProject.getInstance().playerBank.get(uuid));
		pl.sendMessage(ChatColor.GRAY + "   - Player Level: " + ChatColor.AQUA + Profile.get(uuid).getCurrentLevel() + ChatColor.DARK_GRAY +" (" + ChatColor.AQUA + Profile.get(pl.getUniqueId()).getMinLevel() + "/" + Profile.get(pl.getUniqueId()).getMaxLevel() + ChatColor.DARK_GRAY +")");
		pl.sendMessage(ChatColor.GRAY + "   - Player Class: " + ChatColor.GRAY + Profile.get(uuid).getPlayerClass());
		pl.sendMessage(ChatColor.DARK_GRAY + "   --" + ChatColor.AQUA + " Skills " + ChatColor.DARK_GRAY + "--");
		
		
	}
	
	public void CreateProfile(Player pl, String r, String c) throws IOException {
		if(Profile.containsKey(pl.getUniqueId())) {
			pl.sendMessage(ChatColor.RED + "You already have a profile!");
			return;	
		} else {
			double stamina = 10.0;
			Profile.put(pl.getUniqueId(), new Profile(pl.getUniqueId(), r, c, 0, 0, 200, 0, 0, 20, 1, stamina, true, true, true));
			ElderProject.getInstance().playerBank.put(pl.getUniqueId(), 0.0);
			ElderProject.getInstance().saveProfile();
		}
	}
	 
	
	
	public void ProfileExists(Player pl) {
		if(!Profile.containsKey(pl.getUniqueId())) { 
			Gui.ChooseRace(pl);
			return;
		} else {
			 getProfile(pl);
			 Gui.MainGui(pl);
		}
	}
	

}
