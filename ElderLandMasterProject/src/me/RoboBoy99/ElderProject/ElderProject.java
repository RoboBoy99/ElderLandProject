package me.RoboBoy99.ElderProject;


import java.io.File;			
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Rename.RenameCmd;
import me.RoboBoy99.Claims.ClaimsManager;
import me.RoboBoy99.ElderProject.Bounty.BountyCmd;
import me.RoboBoy99.ElderProject.Bounty.BountyManager;
import me.RoboBoy99.ElderProject.Bounty.Events.OnInventoryEvent;
import me.RoboBoy99.ElderProject.Currency.ElderCoinImplementer;
import me.RoboBoy99.ElderProject.Currency.VaultHook;
import me.RoboBoy99.ElderProject.GeneralEvents.CombatEvent;
import me.RoboBoy99.ElderProject.GeneralEvents.DeathEvent;
import me.RoboBoy99.ElderProject.Housing.HousingManager;
import me.RoboBoy99.ElderProject.Housing.Commands.HousingCmd;
import me.RoboBoy99.ElderProject.Housing.Events.ClickEvent;
import me.RoboBoy99.ElderProject.MainClans.ClansManager;
import me.RoboBoy99.ElderProject.MainClans.Cmd.ClanCmd;
import me.RoboBoy99.ElderProject.RaceProfiles.Profile;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import me.RoboBoy99.ElderProject.RaceProfiles.gprofileManager;
import me.RoboBoy99.ElderProject.RaceProfiles.Events.SelectionGuiEvent;
import me.RoboBoy99.ElderProject.RaceProfiles.Events.ChatEvent;
import me.RoboBoy99.ElderProject.RaceProfiles.Events.MainGuiEvent;
import me.RoboBoy99.ElderProject.RaceProfiles.Events.PlayerSprint;
import me.RoboBoy99.ElderProject.RaceProfiles.Events.ProfileJoinEvent;
import me.RoboBoy99.ElderProject.RaceProfiles.Events.ProfileMove;
import me.RoboBoy99.ElderProject.RaceProfiles.Events.ProfileQuitEvent;
import me.RoboBoy99.ElderProject.RaceProfiles.cmds.ProfileCmd;
import me.RoboBoy99.ElderProject.Saving.PlayerData;

public class ElderProject extends JavaPlugin {

	private static ElderProject INSTANCE;
    public ElderCoinImplementer economyImplementer;
    private VaultHook vaultHook;
    public final HashMap<UUID,Double> playerBank = new HashMap<>();
    
	public static ElderProject getInstance() {
		return INSTANCE;
	}
	public ClansManager Cm;
	public ProfilesManager Pm;
	public BountyManager Bm;
	public HousingManager Hm;
	public ClaimsManager ClaimsMa;
	public PlayerData playerData;
	public gprofileManager gp;
	@Override
	public void onEnable() { 
		INSTANCE = this;
        instanceClasses();
        vaultHook.hook();    
        loadProfile();
        gp = new gprofileManager();	
		Pm = new ProfilesManager();
		Cm = new ClansManager();
		Bm = new BountyManager();
		Hm = new HousingManager();
		ClaimsMa = new ClaimsManager();
		RegisterCommands();
		RegisterEvents();
		
			
	}
		
	public void onDisable() {
		vaultHook.unhook();
		try {
			if(!Pm.Profile.isEmpty()) {
				saveProfile();
			}
		} catch (IOException e) {	
			e.printStackTrace();
		}

	}
	
    private void instanceClasses() {
        economyImplementer = new ElderCoinImplementer();
        vaultHook = new VaultHook();
    }
    
	public void RegisterCommands() {
		getCommand("Profile").setExecutor(new ProfileCmd());
		getCommand("Clan").setExecutor(new ClanCmd());
		getCommand("Bounty").setExecutor(new BountyCmd());
		getCommand("Rename").setExecutor(new RenameCmd());
		getCommand("Housing").setExecutor(new HousingCmd());
	}
	
	
	public void RegisterEvents() {
		getServer().getPluginManager().registerEvents(new ProfileJoinEvent(), this);
		getServer().getPluginManager().registerEvents(new ProfileQuitEvent(), this);
		getServer().getPluginManager().registerEvents(new SelectionGuiEvent(), this);
		getServer().getPluginManager().registerEvents(new ProfileMove(), this);
		getServer().getPluginManager().registerEvents(new PlayerSprint(), this);
		getServer().getPluginManager().registerEvents(new ChatEvent(), this);
		getServer().getPluginManager().registerEvents(new OnInventoryEvent(), this);
		getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new CombatEvent(), this);
		getServer().getPluginManager().registerEvents(new MainGuiEvent(), this);
	}
	
	
    public void saveProfile() throws IOException  {
    	for(UUID p : Pm.Profile.keySet()) {
            File f = new File(getDataFolder().getAbsolutePath(), Bukkit.getPlayer(p).getName() + ".yml");
            FileConfiguration c = YamlConfiguration.loadConfiguration(f);
            c.set("Balance", playerBank.get(p));
            c.set("Race", Pm.Profile.get(p).getRace());
            c.set("Class", Pm.Profile.get(p).getPlayerClass());
            c.set("Level", Pm.Profile.get(p).getCurrentLevel());
            c.set("MinXP", Pm.Profile.get(p).getMinLevel());
            c.set("MaxXP", Pm.Profile.get(p).getMaxLevel());        
            c.set("SkillPoints", Pm.Profile.get(p).getSkillPoints());
            c.set("Power", Pm.Profile.get(p).getPower());
            c.set("Health", Pm.Profile.get(p).getHealth());
            c.set("Kills", Pm.Profile.get(p).getKills());
            c.save(f);
    	}
    }

    public void loadProfile() {
    	for(Player p : Bukkit.getOnlinePlayers()) {
            File f = new File(getDataFolder().getAbsolutePath(), p.getName() + ".yml");
            FileConfiguration c = YamlConfiguration.loadConfiguration(f);	
            double bal = (double) c.get("Balance");
            String race = (String) c.get("Race");
            // String pc = (String) c.get("Class");
            // int Lvl = (int) c.get("Level");
            //int MinXP = (int) c.get("MinXP");
            //int MaxXP = (int) c.get("MaxXP");
            //int SkillPoints = (int) c.get("SkillPoints");
            //int Power = (int) c.get("Power");
            //int Health = (int) c.get("Health");
            //int Kills = (int) c.get("Kills");
            //p.sendMessage(p.getUniqueId() + ", " + race + ", " + pc + ", " + Lvl + ", " + MinXP + ", " + MaxXP + ", " + SkillPoints + ", " + Power + ","  + Health + ", " + Kills);
            //Pm.Profile.put(p.getUniqueId(), new Profile(p.getUniqueId(), null, null, race, classs, Kills, Lvl, MinXP, MaxXP, SkillPoints, Health, Power, true, true, true));
            Pm.Profile.put(p.getUniqueId(), new Profile(p.getUniqueId(), race, "test", 0, 0, 0, 0, 0, 0, 0, 0, true, true, true));
            playerBank.put(p.getUniqueId(), bal);
    	}
    }
    


}
	
	
