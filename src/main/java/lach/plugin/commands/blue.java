package lach.plugin.commands;

import lach.plugin.handlers.CustomItemHandler;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class blue implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            // Here we need to give items to our player
            // Create a new ItemStack (type: diamond)
            ItemStack robe = CustomItemHandler.createItem(new ItemStack(Material.CREEPER_HEAD,1), "Blue Robe", Arrays.asList("Blue Robe")); //make a new custom item.
            ItemStack right_glove = CustomItemHandler.createItem(new ItemStack(Material.BLUE_DYE,1), "Blue Gloves", Arrays.asList("Right Blue GLove"));
            ItemStack left_glove = CustomItemHandler.createItem(new ItemStack(Material.SHIELD,1), "Blue Gloves", Arrays.asList("Left Blue Glove"));

            player.getInventory().addItem(right_glove);
            player.getInventory().setHelmet(robe);
            player.getInventory().setItemInOffHand(left_glove);
        }
        return false;
    }
}
