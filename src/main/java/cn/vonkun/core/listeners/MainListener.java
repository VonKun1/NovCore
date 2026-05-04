package cn.vonkun.core.listeners;

import cn.vonkun.core.NovCore;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MainListener implements Listener {
    private final NovCore plugin;

    public MainListener(NovCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPhysics(BlockPhysicsEvent e){
        boolean isEnabled = plugin.getSettingsFile().getFile().getBoolean("set_physics_enabled");
        if (!isEnabled) return;
        if (e.getBlock().getType() != Material.CACTUS) return;
        Block cactus = e.getBlock();
        for (BlockFace face : BlockFace.values()){
            if (face == BlockFace.UP || face == BlockFace.DOWN) continue;
            Block relative = cactus.getRelative(face);
            if (relative.getType() != Material.AIR){
                e.setCancelled(true);
                return;
            }
        }
    }
    @EventHandler
    public void onSpawn(CreatureSpawnEvent e){
        boolean isEnabled = plugin.getSettingsFile().getFile().getBoolean("spawn_enabled");
        if (!isEnabled) return;
        if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL
                || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.EGG) {
            e.setCancelled(true);
        }
    }
}
