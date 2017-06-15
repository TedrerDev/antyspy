package net.tedrerdev.antyspy.listeners;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.inventory.meta.ItemMeta;

import net.tedrerdev.antyspy.AntySpyPlugin;

public class AntyFavListener
  implements Listener
{
  AntySpyPlugin plugin;
  
  public AntyFavListener(AntySpyPlugin plugin)
  {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }
  
	@EventHandler
	public void invt(final InventoryCreativeEvent e) {
		try{
			final Map<Player, Integer> amountget = new HashMap<Player, Integer>();
			final Player p = (Player) e.getWhoClicked();
			final ItemMeta im = e.getCursor().getItemMeta();
			final List<String> lore = new ArrayList<String>();
			amountget.put(p, e.getCursor().getAmount());
			lore.add(ChatColor.GOLD + "[ADMIN]");
			lore.add(ChatColor.GOLD + "Nick: " + ChatColor.GRAY + p.getName());
		    lore.add(ChatColor.GOLD + "Data:" + ChatColor.GRAY + " " + new Date(System.currentTimeMillis()).toLocaleString());
			lore.add(ChatColor.GOLD + "Item: " + ChatColor.GRAY + e.getCursor().getType());
			lore.add(ChatColor.GOLD + "Ilosc: " + ChatColor.GRAY + amountget.get(p));
			im.setLore(lore);
			e.getCursor().setItemMeta(im);
			amountget.put(p, null);
		}catch(Exception ex){
			
		}
		
	}
}