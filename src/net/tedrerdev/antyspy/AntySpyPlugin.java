package net.tedrerdev.antyspy;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import net.tedrerdev.antyspy.listeners.AntyFavListener;
import net.tedrerdev.antyspy.listeners.ColorSignListener;
import net.tedrerdev.antyspy.listeners.ProtectPluginsListener;
import net.tedrerdev.antyspy.listeners.SilentJoinLeaveListener;

public class AntySpyPlugin
  extends JavaPlugin
{
  public static AntySpyPlugin plugin;
  public static Logger log;
  AntyFavListener afl;
  ColorSignListener csl;
  ProtectPluginsListener ppl;
  SilentJoinLeaveListener sjll;
  
  public void onEnable()
  {
    plugin = this;
    log = getLogger();
    this.ppl = new ProtectPluginsListener(this);
    this.afl = new AntyFavListener(this);
    this.csl = new ColorSignListener(this);
    this.sjll = new SilentJoinLeaveListener(this);
  }
  
  public void onDisable()
  {
	  
  }
  
  public static AntySpyPlugin getThis()
  {
    return plugin;
  }
  
  public String fix(String s)
  {
    if (s != null) {
      return ChatColor.translateAlternateColorCodes('&', s);
    }
    return null;
  }
  public static boolean containsIgnoreCase(String[] board, String string)
  {
    String[] arrayOfString;
    int j = (arrayOfString = board).length;
    for (int i = 0; i < j; i++)
    {
      String otherstring = arrayOfString[i];
      if (otherstring.equalsIgnoreCase(string)) {
        return true;
      }
    }
    return false;
  }
}
