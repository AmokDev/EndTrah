package dev.amok.EndTrah.Events;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import org.bukkit.boss.BossBar;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

import dev.amok.EndTrah.Plugin;

public class bossBarEvent implements Listener  {

    public static HashMap<String, Integer> barcheck = new HashMap<>();
    public static BossBar bar = Bukkit.createBossBar(Plugin.getBossBarText(), BarColor.PURPLE, BarStyle.SOLID);

    @EventHandler
    public void barInv(PlayerMoveEvent event) {
        Player s = (Player) event.getPlayer();
        FileConfiguration cfg = Plugin.getInstance().getConfig();

        if (s.getInventory().contains(Material.DRAGON_EGG)) {
            if (barcheck.get(s.getName()) == null) {
                barcheck.put(s.getName(), 0);
            }
            if (barcheck.get(s.getName()) == 0) {
                bar.addPlayer(s);
                barcheck.put(s.getName(), 1);
            }
            if (cfg.getString("eggowner") != s.getName()) {
                cfg.set("eggowner", s.getName());
                Plugin.getInstance().saveConfig();
            }
        } else {
            bar.removePlayer(s);
            barcheck.put(s.getName(), 0);
        }
    }
}
