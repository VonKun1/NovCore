package cn.vonkun.core.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuManager implements Listener {
    private static final Map<UUID,CoreMenu> map = new HashMap<>();

    public static void registerMenu(Player player,CoreMenu menu){
        map.put(player.getUniqueId(),menu);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        CoreMenu menu = map.get(p.getUniqueId());
        if (menu != null && e.getInventory().equals(menu.getInventory())){
            e.setCancelled(true);
            menu.handleClick(e);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        map.remove(e.getPlayer().getUniqueId());
    }
}
