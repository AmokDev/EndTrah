package dev.amok.EndTrah.Commands;

import dev.amok.EndTrah.Plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import org.bukkit.configuration.file.FileConfiguration;

public class endtrahCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        Player s = (Player) sender;
        FileConfiguration cfg = Plugin.getInstance().getConfig();
        String config_restart = cfg.getString("config-restart");
        if (alias.equalsIgnoreCase("endtrah")) {
            if (args.length == 0) {
                s.sendMessage( "§7/endtrah reload");
            } else if (args[0].equalsIgnoreCase("reload")) {
                Plugin i = Plugin.getInstance();
                i.reloadConfig();
                s.sendMessage("");
                s.sendMessage(config_restart);
                s.sendMessage("");
            } else {
                s.sendMessage("§7/endtrah reload");
            }
        }
        return true;
    }
}
