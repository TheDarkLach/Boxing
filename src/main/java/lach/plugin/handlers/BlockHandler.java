package lach.plugin.handlers;

import lach.plugin.Game;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static org.bukkit.Bukkit.broadcastMessage;

public class BlockHandler implements Listener
{
    public BlockHandler(Game plugin)
    {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        if (!event.getPlayer().hasPermission("game.place"))
        {
            broadcastMessage("You can't place that here!");
            event.setCancelled(true);
            return;
        }
        if (event.getBlock().getType() != Material.TNT || event.getBlock().getType() == Material.TNT_MINECART)
        {
            return;
        }
        event.getBlock().setType(Material.AIR);
        broadcastMessage("Nuh uh uh");
    }
}
