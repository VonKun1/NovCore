package cn.vonkun.core.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ChatUtil {

    private static final boolean HAS_PAPI =
            Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;

    public static String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> format(List<String> texts) {
        if (texts == null) return null;
        return texts.stream()
                .map(ChatUtil::format)
                .collect(Collectors.toList());
    }

    public static String format(String text, Player player) {
        String colored = format(text);
        return HAS_PAPI ? PlaceholderAPI.setPlaceholders(player, colored) : colored;
    }

    public static List<String> format(List<String> texts, Player player) {
        if (texts == null) return null;
        return texts.stream()
                .map(line -> format(line, player))
                .collect(Collectors.toList());
    }

    public static void msg(Player player, String text) {
        player.sendMessage(format(text, player));
    }

    public static void msg(Player player, List<String> texts) {
        format(texts, player).forEach(player::sendMessage);
    }
}