package me.RoboBoy99.ElderProject.Currency;

import org.bukkit.Bukkit;	
import org.bukkit.plugin.ServicePriority;

import me.RoboBoy99.ElderProject.ElderProject;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

public class VaultHook {
	
    private ElderProject plugin = ElderProject.getInstance();

    private Economy provider;

    public void hook() {
        provider = plugin.economyImplementer;
        Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "VaultAPI hooked into " + ChatColor.AQUA + plugin);
    }

    public void unhook() {
        Bukkit.getServicesManager().unregister(Economy.class, this.provider);
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "VaultAPI unhooked from " + ChatColor.AQUA + plugin);

    }
}
