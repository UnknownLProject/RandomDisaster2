package me.unknownl.randomdisaster;

import org.bukkit.plugin.java.JavaPlugin;

public final class RandomDisaster extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("disaster").setExecutor(new command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static RandomDisaster plugin;
    public static RandomDisaster getPlugin() {
        return plugin;
    }
}
