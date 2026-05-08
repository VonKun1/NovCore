package cn.vonkun.core.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ChatUtil {
    public static String format(String text){
        return ChatColor.translateAlternateColorCodes('&',text);
    }
    public static List<String> format(List<String> texts){
        if (texts == null) return null;
        return texts.stream()
                .map(ChatUtil::format)
                .collect(Collectors.toList());
    }
    public static String format(String text, Player player){
        if (Bukkit.getServer()
                .getPluginManager()
                .getPlugin("PlaceholderAPI") != null){
            return ChatColor
                    .translateAlternateColorCodes('&',
                            PlaceholderAPI.setPlaceholders(player,text));
        }
        return format(text);
    }
    public static void msg(Player player,String text){
        if (Bukkit.getServer()
                .getPluginManager()
                .getPlugin("PlaceholderAPI") != null){
            player.sendMessage(format(text,player));
            return;
        }
        player.sendMessage(format(text));
    }
    public static void msg(Player player, List<String> texts){
        if (Bukkit.getServer()
                .getPluginManager()
                .getPlugin("PlaceholderAPI") != null){
            for (String s : texts){
                player.sendMessage(format(s,player));
            }
            return;
        }
        for (String s : texts){
            player.sendMessage(format(s));
        }
    }
}
