package net.tedrerdev.antyspy.listeners;

import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.PluginManager;

import net.tedrerdev.antyspy.AntySpyPlugin;

public class ColorSignListener
  implements Listener
{
  AntySpyPlugin plugin;
  
  public ColorSignListener(AntySpyPlugin plugin)
  {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }
  
  @EventHandler
  public void onSignCreate(SignChangeEvent e)
  {
    int i = 0;
    String[] arrayOfString;
    int j = (arrayOfString = e.getLines()).length;
    for (int i1 = 0; i1 < j; i1++)
    {
      String line = arrayOfString[i1];
      
      String line2 = this.plugin.fix(line);
      if (line2 != null) {
        e.setLine(i1, this.plugin.fix(line));
      }
      i1++;
    }
  }
}
