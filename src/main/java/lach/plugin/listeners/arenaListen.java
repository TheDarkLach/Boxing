package lach.plugin.listeners;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.regions.RegionSelector;
import org.bukkit.World;
import org.bukkit.event.Listener;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.RegionSelector;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
//Okay so instead of detecting inside a space I will just detect on a certain block, way easier
public class arenaListen extends JavaPlugin implements Listener
{
    private RegionSelector regionSelector;
    public void onEnable()
    {
        WorldEdit worldEdit = WorldEdit.getInstance();
        this.regionSelector = worldEdit.getSessionManager().get(BukkitAdapter.adapt(player)).getRegionSelector(BukkitAdapter.adapt(player.getWorld()));
        getServer().getPluginManager().registerEvents(this, this);
    }
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        BlockVector3 blockVector3 = BlockVector3.at(location.getX(), location.getY(), location.getZ());
        if (regionSelector.contains(blockVector3)) {
            // The player has entered the region
            // Do something here, e.g. send a message to the player
            player.sendMessage("You have entered the region!");
        }
    }
}
