package me.jade.plugins;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class MyFirstPlugin extends JavaPlugin implements Listener {
    public void onEnable() {
        getLogger().info("My first plugin");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("jade")) {
            if (sender instanceof Player) {
                Player player = ((Player) sender);
                if (player.hasPermission("myfistplugin.jade")) {
                    player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                    Entity e =  player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT);
                    e.setPassenger(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                }
            } else {
                sender.sendMessage("Only players can use this command!");
            }
        }
        return true;
    }

    @EventHandler
    public void onClick(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.OCELOT) {
            event.getPlayer().setPassenger(event.getRightClicked());
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.CAT_PURREOW, 1.0F, 1.0F);
            event.getPlayer().setVelocity(new Vector(0, 15, 0));
        }
    }
}
