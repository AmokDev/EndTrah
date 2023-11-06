package dev.amok.EndTrah;

import org.bukkit.plugin.java.JavaPlugin;

import dev.amok.EndTrah.Initializers.CommandInit;
import dev.amok.EndTrah.Initializers.EventInit;

public class Plugin extends JavaPlugin {

    public static JavaPlugin plugin;
    private static Plugin instance;

    @Override
    public void onEnable() {
        Plugin.plugin = this;
        instance = this;
        getLogger().info("Loading config...");
        CommandInit.init();
        EventInit.init();
        getLogger().info("Plugin started!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin stopped!");
    }

    public static Plugin getInstance() {
        return instance;
    }

    public static String getBossBarText() {
        String bartxt = Plugin.getInstance().getConfig().getString("bartext");
        return bartxt;
    }
}
