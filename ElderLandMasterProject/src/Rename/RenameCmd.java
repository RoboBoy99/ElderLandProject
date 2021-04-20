package Rename;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class RenameCmd implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       if(!cmd.getName().equalsIgnoreCase("Rename"))
           return false;
       if (!(sender instanceof Player))
           return false;

       Player player = (Player) sender;
       setName(player.getItemInHand(), args[0], false);
       hideFlags(player.getItemInHand());
	return false;
	}
	
	
    public void setName(ItemStack item, String name, boolean overrideDefaultFormat) {
        ItemMeta itemStackMeta = item.getItemMeta();
        itemStackMeta.setDisplayName(formatString(name, overrideDefaultFormat));
        item.setItemMeta(itemStackMeta);
    }
    
    public void setLore(ItemStack itemStack, String name, boolean overrideDefaultFormat) {
        String lore = formatString(name, overrideDefaultFormat);
        List<String> loreList = multiLineLore(lore, overrideDefaultFormat);
        ItemMeta itemStackMeta = itemStack.getItemMeta();
        itemStackMeta.setLore(loreList);
        itemStack.setItemMeta(itemStackMeta);
    }
    
    private List<String> multiLineLore(String lore, boolean overrideDefaultFormat) {
        List<String> loreList = Arrays.asList(lore.split("\\\\n"));
        ListIterator<String> itr = loreList.listIterator();
        while (itr.hasNext()) {
            itr.set(formatString(itr.next(), overrideDefaultFormat));
        }
        return loreList;
    }
    
    public void hideFlags(ItemStack item) {
        ItemMeta itemStackMeta = item.getItemMeta();
        itemStackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStackMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStackMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(itemStackMeta);
    }
    
    public String formatString(String string, boolean overrideDefaultFormat) {
        // The &r is added at the beginning to remove default formatting
        if (!overrideDefaultFormat || string.startsWith("&r")) {
            return ChatColor.translateAlternateColorCodes('&', string);
        } else {
            return ChatColor.translateAlternateColorCodes('&', "&r" + string);
        }
    }
}
