package com.github.huda0209.entityspawncanceller;

import com.github.huda0209.entityspawncanceller.command.commandHandler;
import com.github.huda0209.entityspawncanceller.listener.EntitySpawnEventListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class EntitySpawnCanceller extends JavaPlugin implements CommandExecutor {

    final String pluginName = this.getDescription().getName();

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getCommand("esc").setExecutor(new commandHandler(this));
        getServer().getPluginManager().registerEvents(new EntitySpawnEventListener(this),this);
        configload.loadConfig(this);
        String[] EnableMessage = {"=============================","Plugin Name : "+pluginName ,"Author : "+ this.getDescription().getAuthors(),"============================="};
        for (String s : EnableMessage) {
            getLogger().info(s);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName+"is disable");
    }

    public void logger(String msg){
        getLogger().info(msg);
    }
}