package lach.plugin;

import lach.plugin.commands.*;
import lach.plugin.handlers.BlockHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Game extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Game plugin has been enabled!");
        new BlockHandler(this);

        this.getCommand("blocks").setExecutor(new blocks());
        this.getCommand("ref").setExecutor(new ref());
        this.getCommand("arena").setExecutor(new arena());
        this.getCommand("blue").setExecutor(new blue());
        this.getCommand("red").setExecutor(new red());
        this.getCommand("fan").setExecutor(new fan());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Game plugin has been disabled!");
    }
}
