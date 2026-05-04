package cn.vonkun.core.utils;

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
    public static void msg(Player player,String text){
        player.sendMessage(format(text));
    }
    public static void msg(Player player, List<String> texts){
        for (String s : texts){
            player.sendMessage(format(s));
        }
    }
}
