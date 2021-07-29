package com.github.huda0209.entityspawncanceller.command;

import com.github.huda0209.entityspawncanceller.EntitySpawnCanceller;
import com.github.huda0209.entityspawncanceller.configload;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;

import java.util.Locale;

public class SpawnCancelEntityManager {
    public static void addEntity(EntitySpawnCanceller pl, CommandSender sender, String TempEntityType){
        String entityTypeTxT = TempEntityType.toUpperCase(Locale.ROOT);
        EntityType entityType = getEntityType(entityTypeTxT);
        if(entityType == null){
            sender.sendMessage("§9[" + pl.getDescription().getName() + "]§c "+entityTypeTxT+" don't exist in \"org.bukkit.entity.EntityType\".");
            return;
        }
        if(configload.hasSpawnCancelEntity(entityTypeTxT)){
            sender.sendMessage("§9[" + pl.getDescription().getName() + "]§c "+entityTypeTxT+" already exists.");
            return;
        }

        Boolean result = configload.addSpawnCancelEntityList(entityTypeTxT,pl);
        if(!result){
            sender.sendMessage("§9[" + pl.getDescription().getName() + "]§c While add List in \"SpawnCancelEntities\", occurred error. Please retry to run this command.");
            return;
        }
        sender.sendMessage("§9[" + pl.getDescription().getName() + "]§a Succeed to add "+entityTypeTxT+" in SpawnCancelEntity.");
    }

    public static void removeEntity(EntitySpawnCanceller pl, CommandSender sender, String TempEntityType){
        String entityTypeTxT = TempEntityType.toUpperCase(Locale.ROOT);
        EntityType entityType = getEntityType(entityTypeTxT);
        if(entityType == null){
            sender.sendMessage("§9[" + pl.getDescription().getName() + "]§c "+entityTypeTxT+" don't exist in \"org.bukkit.entity.EntityType\".");
            return;
        }
        if(!configload.hasSpawnCancelEntity(entityTypeTxT)){
            sender.sendMessage("§9[" + pl.getDescription().getName() + "]§c "+entityTypeTxT+" don't exists.");
            return;
        }

        Boolean result = configload.removeSpawnCancelEntityList(entityTypeTxT,pl);
        if(!result){
            sender.sendMessage("§9[" + pl.getDescription().getName() + "]§c While remove List in \"SpawnCancelEntities\", occurred error. Please retry to run this command.");
            return;
        }
        sender.sendMessage("§9[" + pl.getDescription().getName() + "]§a Succeed to remove "+entityTypeTxT+" in SpawnCancelEntity.");
    }

    private static EntityType getEntityType(String entityTypeTxT){
        try{
            return EntityType.valueOf(entityTypeTxT);
        }catch (Exception e){
            return null;
        }
    }
}
