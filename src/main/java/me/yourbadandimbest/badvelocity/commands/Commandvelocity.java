package me.yourbadandimbest.badvelocity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class Commandvelocity implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length < 3)
            // Not enough arguments
            return false;

        Player user;
        if (args.length > 3 && (sender.hasPermission("bad.velocity.others") || sender.isOp()))
            user = Bukkit.getPlayer(args[3]);
        else
            user = (sender instanceof Player) ? (Player) sender : null;

        if (user == null) {
            // Player not found
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        final double x = args[0].startsWith("~") ? user.getVelocity().getX() + (args[0].length() > 1 ? Double.parseDouble(args[0].substring(1)) : 0) : Double.parseDouble(args[0]);
        final double y = args[1].startsWith("~") ? user.getVelocity().getY() + (args[1].length() > 1 ? Double.parseDouble(args[1].substring(1)) : 0) : Double.parseDouble(args[1]);
        final double z = args[2].startsWith("~") ? user.getVelocity().getZ() + (args[2].length() > 1 ? Double.parseDouble(args[2].substring(1)) : 0) : Double.parseDouble(args[2]);

        user.setVelocity(new Vector(x,y,z));
        return true;
    }
}