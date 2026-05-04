package cn.vonkun.core.item;

import cn.vonkun.core.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomItem {
    public static ItemStack setItem(Material type, String name){
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatUtil.format(name));
            item.setItemMeta(meta);
        }

        return item;
    }
    public static ItemStack setItem(Material type, String name, String... lore){
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatUtil.format(name));
            if (lore != null && lore.length > 0){
                List<String> loreList = Arrays.asList(lore)
                        .stream()
                        .map(ChatUtil::format)
                        .collect(Collectors.toList());
                meta.setLore(loreList);
            }
            item.setItemMeta(meta);
        }

        return item;
    }
    public static ItemStack setItem(Material type, String name, List<String> lore){
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatUtil.format(name));
            if (lore != null) {
                meta.setLore(ChatUtil.format(lore));
            }
            item.setItemMeta(meta);
        }

        return item;
    }
    public static ItemStack addEnchantment(ItemStack item, Enchantment enchantment,int level){
        item.addEnchantment(enchantment,level);
        return item;
    }
}
