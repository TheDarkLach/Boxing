package lach.plugin.commands;

import lach.plugin.handlers.CustomItemHandler;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.Arrays;


public class ref implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings)
    {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Here we need to give items to our player

            ItemStack whistle = CustomItemHandler.createItem(new ItemStack(Material.YELLOW_DYE,1), "Whistle", Arrays.asList("Referee Whistle","Right-click to blow")); //make a new custom item.

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(whistle);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
