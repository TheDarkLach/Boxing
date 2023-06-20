package lach.plugin.commands;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.session.SessionManager;
import com.sk89q.worldedit.session.SessionOwner;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class arena implements CommandExecutor
{
    File file = new File("plugins/WorldEdit/schematics/arena.schem");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player player = (Player) sender;
        World world = Bukkit.getWorld("world");
        ClipboardFormat format = ClipboardFormats.findByFile(file);
        Clipboard clipboard;



        try (ClipboardReader reader = format.getReader(new FileInputStream(file)))
        {
            clipboard = reader.read();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(BukkitAdapter.adapt(world), -1)) {

            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()))
                    .ignoreAirBlocks(false)
                    .build();
            Operations.complete(operation);
        }
        catch (WorldEditException e)
        {
            throw new RuntimeException(e);
        }

        BlockVector3 playerLocation = BukkitAdapter.asBlockVector(player.getLocation());
        // Calculate the region corners based on the player's location
        BlockVector3 corner1 = playerLocation.add(-7, 0, -7); // 15 / 2 = 7.5 -> rounded to 7
        BlockVector3 corner2 = playerLocation.add(7, 0, 7);

        // Create a CuboidRegion selection with the two corners
        CuboidRegion arena = new CuboidRegion(corner1, corner2);

        sender.sendMessage("Arena region set to 15x15 around your current location.");
        sender.sendMessage(String.valueOf(arena.getLength()));

        return true;
    }
}
