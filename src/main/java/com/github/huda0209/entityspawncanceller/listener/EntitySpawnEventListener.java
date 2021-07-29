package com.github.huda0209.entityspawncanceller.listener;

import com.github.huda0209.entityspawncanceller.EntitySpawnCanceller;
import com.github.huda0209.entityspawncanceller.configload;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;


public class EntitySpawnEventListener implements Listener {
    private final EntitySpawnCanceller plugin;
    public EntitySpawnEventListener(EntitySpawnCanceller pl) {
        this.plugin = pl;
    }

    @EventHandler
    public void EntitySpawnEventHandler(EntitySpawnEvent event){
        if(!configload.getIsEnable()) return;

        Entity entity = event.getEntity();
        String EntityType = event.getEntityType().toString();
        if(!configload.hasSpawnCancelEntity(EntityType)) return;
        event.setCancelled(true);
        System.out.println("["+plugin.getDescription().getName()+"]\n-------------------------------\nTo spawn "+EntityType+" successful Cancelled.\n"+
                "World : "+entity.getWorld().getName()+"\n"+
                "Location: ("+entity.getLocation().getX()+", "+entity.getLocation().getY()+", "+entity.getLocation().getZ()+
                "\n-------------------------------\n");
    }
}
