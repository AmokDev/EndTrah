package dev.amok.EndTrah.Events;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import org.bukkit.entity.EntityType;

import org.bukkit.configuration.file.FileConfiguration;

import dev.amok.EndTrah.Plugin;

public class crystalDamageEvent implements Listener  {

    @EventHandler
    public void crystalDamge(EntityDamageByEntityEvent event) {
        FileConfiguration cfg = Plugin.getInstance().getConfig();
        int damage = cfg.getInt("crystal_damage");
        EntityType type = event.getDamager().getType();
        if (type == EntityType.ENDER_CRYSTAL) {
            event.setDamage(damage);
        }
    }
}
