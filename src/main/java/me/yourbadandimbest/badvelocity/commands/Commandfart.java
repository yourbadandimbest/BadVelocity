package me.yourbadandimbest.badvelocity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Commandfart implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Player user;
        if (args.length > 0 && (sender.hasPermission("bad.fart.others") || sender.isOp()))
            user = Bukkit.getPlayer(args[0]);
        else
            user = (sender instanceof Player) ? (Player) sender : null;

        if (user == null) {
            // Player not found
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        user.setVelocity(user.getVelocity().setY(10));

        // Silly message
        user.sendMessage(ChatColor.GOLD + "You have been poated!");
        if (user != sender)
            sender.sendMessage((ChatColor.GOLD + user.getName() + " has been poated!"));

        return true;
    }
}