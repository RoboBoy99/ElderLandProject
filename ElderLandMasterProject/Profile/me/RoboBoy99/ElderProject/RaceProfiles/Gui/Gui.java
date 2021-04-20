package me.RoboBoy99.ElderProject.RaceProfiles.Gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;	
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.RoboBoy99.ElderProject.ElderProject;
import me.RoboBoy99.ElderProject.RaceProfiles.ProfilesManager;
import me.RoboBoy99.ElderProject.RaceProfiles.gprofileManager;
import net.md_5.bungee.api.ChatColor;

public class Gui {


	
	
	public static void Skills(Player player) {
		//Inventory Skills = Bukkit.createInventory(player, 45, ChatColor.DARK_GRAY + "ElderLands Menu");
		
		ItemStack H = new ItemStack(Material.POTION);
		ItemMeta HM = H.getItemMeta();
		HM.setDisplayName(ChatColor.RED + "Health: ");
	}
	
	public static void ChooseRaceGuiBeta(Player pl) {
        Location location = pl.getLocation().toVector().add(pl.getLocation().getDirection().multiply(2)).toLocation(pl.getWorld());

        final ArmorStand armorS = (ArmorStand) pl.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        
        final ArmorStand Next = (ArmorStand) pl.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        
		Next.setVisible(false);
        armorS.setVisible(false);
		//armorS.setGlowing(true);
        
        Next.setCustomName(ChatColor.GREEN + "Next");   
		armorS.setCustomName(ChatColor.AQUA + "Humans");
		
		armorS.setCustomNameVisible(true);
		Next.setCustomNameVisible(true);
		Next.setGravity(false);
		armorS.setGravity(false);
		
     
        Location newLoc = armorS.getLocation();
        Location NextLoc = armorS.getLocation();
        
        newLoc.setYaw(pl.getLocation().getYaw() + 180.0f);
        armorS.teleport(newLoc);
        
        NextLoc.setYaw(pl.getLocation().getYaw() + 290.0f);
        Next.teleport(NextLoc);
		//armorS.setHelmet(arg0);

		
	}
	

	
	@SuppressWarnings("deprecation")
	public static void LostChoosenGui(Player player) {
		gprofileManager gp = ElderProject.getInstance().gp;
		
		UUID uuid = player.getUniqueId();
		Inventory mg = Bukkit.createInventory(player, 27, ChatColor.DARK_PURPLE + "Confirmation menu");
		boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
		ItemStack skull = new ItemStack(type, 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
		meta.setDisplayName(Bukkit.getOfflinePlayer(uuid).getName());
		skull.setItemMeta(meta);
		meta.setDisplayName(ChatColor.GRAY + "End Result ");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "Race > " + ChatColor.GREEN + gp.Profile.get(uuid).getRace());
		lore.add(ChatColor.GRAY + "Class > " + ChatColor.GREEN + gp.Profile.get(uuid).getPClass());
		lore.add(ChatColor.GRAY + "Spawn Location > " + ChatColor.GREEN + "the town of your race");
		meta.setLore(lore);
		skull.setItemMeta(meta);
		mg.setItem(13, skull);
		
		
		ItemStack confirm = new ItemStack(Material.GREEN_CONCRETE, 1);
		ItemMeta cm = confirm.getItemMeta();
		cm.setDisplayName(ChatColor.GREEN + "Confirm your profile");
		List<String> lore1 = new ArrayList<>();
		lore1.add(ChatColor.DARK_GRAY + "you can only change your profile ones in the game");
		cm.setLore(lore1);
		confirm.setItemMeta(cm);
		mg.setItem(11, confirm);
		
		ItemStack back = new ItemStack(Material.RED_CONCRETE, 1);
		ItemMeta bm = back.getItemMeta();
		bm.setDisplayName(ChatColor.RED + "Go back");
		back.setItemMeta(bm);
		mg.setItem(15, back);
		
		player.openInventory(mg);
		

		
		
	}
	
	@SuppressWarnings("deprecation")
	public static void ChooseClass(Player player) {
		Inventory ChooseRace = Bukkit.createInventory(player, 27, ChatColor.DARK_GREEN + "Choose Your class");
		boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");		
		
		ItemStack skull1 = new ItemStack(type, 1);
		SkullMeta meta1 = (SkullMeta) skull1.getItemMeta();
		meta1.setOwner(Bukkit.getOfflinePlayer("crashdummie99").getName());
		meta1.setDisplayName(ChatColor.GRAY + "Class > " + "???");
		skull1.setItemMeta(meta1);
		ChooseRace.setItem(10, skull1);
		
		ItemStack skull2 = new ItemStack(type, 1);
		SkullMeta meta2 = (SkullMeta) skull2.getItemMeta();
		meta2.setOwner(Bukkit.getOfflinePlayer("crashdummie99").getName());
		meta2.setDisplayName(ChatColor.GRAY + "Class > " + "???");
		skull2.setItemMeta(meta2);
		ChooseRace.setItem(12, skull2);
		
		ItemStack skull3 = new ItemStack(type, 1);
		SkullMeta meta3 = (SkullMeta) skull3.getItemMeta();
		meta3.setOwner(Bukkit.getOfflinePlayer("crashdummie99").getName());
		meta3.setDisplayName(ChatColor.GRAY + "Class > " + "???");
		skull3.setItemMeta(meta3);
		ChooseRace.setItem(14, skull3);
		
		ItemStack skull4 = new ItemStack(type, 1);
		SkullMeta meta4 = (SkullMeta) skull4.getItemMeta();
		meta4.setOwner(Bukkit.getOfflinePlayer("crashdummie99").getName());
		meta4.setDisplayName(ChatColor.GRAY + "Class > " + "???");
		skull4.setItemMeta(meta4);
		ChooseRace.setItem(16, skull4);
		
		ItemStack back = new ItemStack(Material.RED_CONCRETE, 1);
		ItemMeta bm = back.getItemMeta();
		bm.setDisplayName(ChatColor.RED + "Go back");
		back.setItemMeta(bm);
		ChooseRace.setItem(26, back);
		
		
		player.openInventory(ChooseRace);
	}
	
	
	public static void ChooseRace(Player player) {
		Inventory ChooseRace = Bukkit.createInventory(player, 27, ChatColor.GOLD + "Choose Your Race?");
		ItemStack head = new ItemStack(Material.PLAYER_HEAD);
		ItemStack head1 = new ItemStack(Material.PLAYER_HEAD);
		ItemStack head2 = new ItemStack(Material.PLAYER_HEAD);
		ItemStack head3 = new ItemStack(Material.PLAYER_HEAD);
		
	    ItemMeta headM = head.getItemMeta();
		headM.setDisplayName(ChatColor.GRAY + "Race > " + ChatColor.RED + "Orcs");
		head.setItemMeta(headM);
		ChooseRace.setItem(10, head);
		ItemMeta headM1 = head1.getItemMeta();
		headM1.setDisplayName(ChatColor.GRAY + "Race > " + ChatColor.AQUA + "Humans");
		head1.setItemMeta(headM1);
		ChooseRace.setItem(12, head1);
		
		ItemMeta headM2 = head2.getItemMeta();
		headM2.setDisplayName(ChatColor.GRAY + "Race > " + ChatColor.GREEN + "Elves");
		head2.setItemMeta(headM2);
		ChooseRace.setItem(14, head2);
		
		ItemMeta headM3 = head3.getItemMeta();
		headM3.setDisplayName(ChatColor.GRAY + "Race > " + ChatColor.YELLOW + "Dwarves");
		head3.setItemMeta(headM3);
		ChooseRace.setItem(16, head3);
		//headM.setDisplayName(ChatColor.);
		
		
		player.openInventory(ChooseRace);
	}
	
	public static void SettingsGui(Player player) {
		Inventory sg = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "Settings");
		
		ItemStack e = new ItemStack(Material.EXPERIENCE_BOTTLE);
		ItemMeta em = e.getItemMeta();
		em.setDisplayName(ChatColor.AQUA + "Show your level");
		e.setItemMeta(em);
		sg.setItem(20	, e);
		
		
		player.openInventory(sg);
	}
	
	
	public static void MainGui(Player player) {
		ProfilesManager pm = ElderProject.getInstance().Pm;
		Inventory mg = Bukkit.createInventory(player, 45, ChatColor.DARK_PURPLE + "ElderLands Menu");
		ItemStack Head = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta Headm = Head.getItemMeta();
		Headm.setDisplayName(ChatColor.YELLOW + "Your Profile");
		
		Head.setItemMeta(Headm);
		mg.setItem(13, Head);
		
		ItemStack Skills = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta Skillsm = Skills.getItemMeta();
		Skillsm.setDisplayName(ChatColor.AQUA + "Skills");
		Skills.setItemMeta(Skillsm);
		mg.setItem(19, Skills);
		
		ItemStack ec = new ItemStack(Material.ENDER_CHEST);
		ItemMeta ecM = ec.getItemMeta();
		ecM.setDisplayName(ChatColor.LIGHT_PURPLE + "Ender Chest");
		ec.setItemMeta(ecM);
		mg.setItem(22, ec);
		
		ItemStack Stats = new ItemStack(Material.BOOK);
		ItemMeta StatsM = Stats.getItemMeta();
		StatsM.setDisplayName(ChatColor.GREEN + "Stats");
		Stats.setItemMeta(StatsM);
		mg.setItem(20, Stats);
		
		ItemStack Quests = new ItemStack(Material.MOJANG_BANNER_PATTERN);
		ItemMeta Qm = Quests.getItemMeta();
		Qm.setDisplayName(ChatColor.GOLD + "Quests");
		Quests.setItemMeta(Qm);
		mg.setItem(21, Quests);
		
		ItemStack Guild = new ItemStack(Material.LOOM);
		ItemMeta Gm = Guild.getItemMeta();
		Gm.setDisplayName(ChatColor.GOLD + "Guild");
		Guild.setItemMeta(Gm);
		mg.setItem(23, Guild);
		
		ItemStack Housing = new ItemStack(Material.DARK_OAK_DOOR);	
		ItemMeta Hm = Housing.getItemMeta();
		Hm.setDisplayName(ChatColor.GREEN + "Housing");
		Housing.setItemMeta(Hm);
		mg.setItem(24, Housing);
		
		ItemStack Clan = new ItemStack(Material.BEE_NEST);
		ItemMeta Cm = Clan.getItemMeta();
		Cm.setDisplayName(ChatColor.GREEN + "Clan");
		Clan.setItemMeta(Cm);
		mg.setItem(25, Clan);
		
		@SuppressWarnings("deprecation")
		ItemStack warnings = new ItemStack(Material.LEGACY_REDSTONE);
		ItemMeta warningsM = warnings.getItemMeta();
		warningsM.setDisplayName(ChatColor.RED + "⚠" + "");
		warnings.setItemMeta(warningsM);
		mg.setItem(44, warnings);
		
		@SuppressWarnings("deprecation")
		ItemStack Settings = new ItemStack(Material.LEGACY_TRIPWIRE_HOOK);
		ItemMeta Sm = Settings.getItemMeta();
		Sm.setDisplayName(ChatColor.YELLOW + "Settings");
		List<String> lore = new ArrayList<>();
		if(pm.Profile.get(player.getUniqueId()).ShowLvl() == true) {
			lore.add(ChatColor.GRAY + "Showlvl > " + ChatColor.GREEN + "true");
		} else {
			lore.add(ChatColor.GRAY + "Showlvl > " + ChatColor.RED + "false");
		}
		
		if(pm.Profile.get(player.getUniqueId()).ShowGuildInfo() == true) {
			lore.add(ChatColor.GRAY + "ShowGuildInfo > " + ChatColor.GREEN + "true");
		} else {
			lore.add(ChatColor.GRAY + "ShowGuildInfo > " + ChatColor.RED + "false");
		}
		
		if(pm.Profile.get(player.getUniqueId()).ShowClanInfo() == true) {
			lore.add(ChatColor.GRAY + "ShowClanInfo > " + ChatColor.GREEN + "true");
		} else {
			lore.add(ChatColor.GRAY + "ShowClanInfo > " + ChatColor.RED + "false");
		}
		Sm.setLore(lore);
		Settings.setItemMeta(Sm);
		mg.setItem(31, Settings);
		
		
		
		player.openInventory(mg);
	}
	
	
}
