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
        getServer().getPluginManager().registerEvents(this, this);
    }
    public void onPlayerMove(PlayerMoveEvent event) {
        // here we will check if they are on a certain block
    }
}
