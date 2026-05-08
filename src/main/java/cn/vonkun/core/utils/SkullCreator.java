package cn.vonkun.core.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class SkullCreator {
    public static ItemStack fromBase64(String base64){
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        applyBase64(meta,base64);
        skull.setItemMeta(meta);
        return skull;
    }
    private static void applyBase64(SkullMeta meta, String base64){
        GameProfile profile = buildProfile(base64);
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        }catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    private static GameProfile buildProfile(String base64){
        GameProfile profile = new GameProfile(UUID.randomUUID(), "skull");
        profile.getProperties().put("textures", new Property("textures", base64));
        return profile;
    }
}


