package net.tedrerdev.antyspy.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;

import net.tedrerdev.antyspy.AntySpyPlugin;

public class ProtectPluginsListener
  implements Listener
{
  AntySpyPlugin plugin;
  
  public ProtectPluginsListener(AntySpyPlugin plugin)
  {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }
  
  @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
    Player player = event.getPlayer();
    if ((!player.getPlayer().getDisplayName().equalsIgnoreCase("Wujo")))
    {
      String message = event.getMessage();
      String[] splittedMessage = message.split(" ");
      String[] pluginCommands = { "/pl", "/plugins", "/?", "/help" };
      String[] versionCommands = { "/ver", "/version", "/about" };
      if (AntySpyPlugin.containsIgnoreCase(pluginCommands, splittedMessage[0]))
      {
        event.setCancelled(true);
        player.sendMessage(ChatColor.BLACK + "" + ChatColor.BOLD + ChatColor.MAGIC + "#####");
        player.sendMessage(ChatColor.GOLD + "Lista naszych pluginow:");
        player.sendMessage(ChatColor.DARK_RED + "  http://youtu.be/dQw4w9WgXcQ  ");
        player.sendMessage(ChatColor.BLACK + "" + ChatColor.BOLD + ChatColor.MAGIC + "#####");
      }
      if (AntySpyPlugin.containsIgnoreCase(versionCommands, splittedMessage[0]))
      {
        event.setCancelled(true);
        player.sendMessage("§fThis server is running CraftZbigniew version git-farrlor-1360 (MC: 1.7.10) (Implementing API version 1.7.10-R0.1-SNAPSHOT)");
      }
    }
  }
}