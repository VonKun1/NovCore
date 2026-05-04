package cn.vonkun.core.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CoreMenu implements MenuAPI.CustomMenu{
    private final Inventory inventory;
    private final Map<Integer,Consumer<InventoryClickEvent>> map = new HashMap<>();

    public CoreMenu(String title, int rows){
        this.inventory = Bukkit.createInventory(null,rows * 9,title);
    }

    @Override
    public void setItem(int slot, ItemStack item, Consumer<InventoryClickEvent> action) {
        this.inventory.setItem(slot,item);
        if (action != null) map.put(slot, action);
    }

    @Override
    public void open(Player player) {
        player.openInventory(inventory);
        MenuManager.registerMenu(player,this);
    }

    public void handleClick(InventoryClickEvent e){
        Consumer<InventoryClickEvent> action = map.get(e.getRawSlot());
        if (action != null) action.accept(e);
    }

    public Inventory getInventory(){
        return this.inventory;
    }
}
