package cn.vonkun.core.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface MenuAPI {
    CustomMenu createMenu(String title,int rows);

    interface CustomMenu {
        void setItem(int slot, ItemStack item, Consumer<InventoryClickEvent> action);
        void open(Player player);
    }
}
