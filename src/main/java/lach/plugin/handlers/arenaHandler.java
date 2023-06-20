package lach.plugin.handlers;

import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class arenaHandler
{
    public boolean hasPlayerEnteredRegion(Player player, Region region) {
        WorldEdit worldEdit = WorldEdit.getInstance();
        //RegionSelector selector = worldEdit.getSessionManager().get(BukkitAdapter.adapt(player)).getRegionSelector(BukkitAdapter.adapt(player.getWorld()));
        Location playerLocation = player.getLocation();
        BlockVector3 blockVector3 = BlockVector3.at(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ());
        return region.contains(blockVector3);
    }
}
