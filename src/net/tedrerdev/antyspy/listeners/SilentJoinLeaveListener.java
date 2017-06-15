package net.tedrerdev.antyspy.listeners;

import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;

import net.tedrerdev.antyspy.AntySpyPlugin;

public class SilentJoinLeaveListener
  implements Listener
{
  AntySpyPlugin plugin;
  
  public SilentJoinLeaveListener(AntySpyPlugin plugin)
  {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event)
  {
	  event.setJoinMessage(null);
  }
  
  @EventHandler
  public void onPlayerLeave(PlayerQuitEvent event)
  {
      event.setQuitMessage(null);
  }
  
  @EventHandler
  public void onPlayerKick(PlayerKickEvent event)
  {
      event.setLeaveMessage(null);
  }
}