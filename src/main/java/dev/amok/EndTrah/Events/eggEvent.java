package dev.amok.EndTrah.Events;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

import dev.amok.EndTrah.Plugin;

public class eggEvent implements Listener  {

    @EventHandler
    public void eggInv(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            Player s = (Player) event.getEntity();

            FileConfiguration cfg = Plugin.getInstance().getConfig();
            List<String> egglore = cfg.getStringList("egglore");
            String eggname = cfg.getString("eggname");
            String title = cfg.getString("title");
            String subtitle = cfg.getString("subtitle");

            if (event.getItem().getItemStack().getType() == Material.DRAGON_EGG) { //.getName().equals("Dragon Egg")) {
                ItemStack item = event.getItem().getItemStack();
                ItemMeta meta = item.getItemMeta();
                meta.setLore(egglore);
                meta.setDisplayName(eggname);
                item.setItemMeta(meta);
                s.sendTitle(title, subtitle, 20, 40, 20);

                cfg.set("eggowner", s.getName());
                Plugin.getInstance().saveConfig();
            }
        }
    }
}
