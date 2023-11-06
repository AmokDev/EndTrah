package dev.amok.EndTrah.Commands;

import dev.amok.EndTrah.Plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class eggCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        Player s = (Player) sender;
        FileConfiguration cfg = Plugin.getInstance().getConfig();
        String eggowner = cfg.getString("eggowner");
        String eggmsg = cfg.getString("eggmsg");
        s.sendMessage(eggmsg + " " + eggowner);
        return true;
    }
}
