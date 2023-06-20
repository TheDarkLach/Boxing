package lach.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fan implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            player.setGameMode(org.bukkit.GameMode.SPECTATOR);
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);
            player.sendMessage("You are now a fan!");
        }
        return false;
    }
}
