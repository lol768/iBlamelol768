package me.jade.plugins;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created with IntelliJ IDEA.
 * User: test
 * Date: 8/5/13
 * Time: 4:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyFirstPlugin extends JavaPlugin {
       public void onEnable() {
              getLogger().info("My first plugin");
       }
}
