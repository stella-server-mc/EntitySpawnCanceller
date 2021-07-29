package com.github.huda0209.entityspawncanceller;

import org.bukkit.configuration.Configuration;

import java.util.List;

public class configload {

    public static List<String> EntityLsit;
    public static boolean isEnable = true;
    private static Configuration config;

    public static void loadConfig(EntitySpawnCanceller pl){
        try{
            config = pl.getConfig();
        }catch (Exception exception){
            System.out.println("[" + pl.getDescription().getName() + "]While load the config file, occurred error.");
            return;
        }

        EntityLsit = config.getStringList("SpawnCancelEntities");
    }

    public static boolean getIsEnable(){
        return isEnable;
    }
    public static void setIsEnable(Boolean bool){
        isEnable = bool;
    }

    //EntityList
    public static Boolean hasSpawnCancelEntity(String EntityTypeTxT){
        return EntityLsit.contains(EntityTypeTxT);
    }

    public static Boolean addSpawnCancelEntityList(String EntityTypeTxT,EntitySpawnCanceller pl){
        if(EntityLsit.contains(EntityTypeTxT)) return false;
        EntityLsit.add(EntityTypeTxT);
        config.set("SpawnCancelEntities",EntityLsit);
        pl.saveConfig();
        return true;
    }

    public static Boolean removeSpawnCancelEntityList(String EntityTypeTxT,EntitySpawnCanceller pl){
        if(!EntityLsit.contains(EntityTypeTxT)) return false;
        EntityLsit.remove(EntityTypeTxT);
        config.set("SpawnCancelEntities",EntityLsit);
        pl.saveConfig();
        return true;
    }
}
