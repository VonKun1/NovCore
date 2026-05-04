package cn.vonkun.core;

import cn.vonkun.core.commands.MainCommand;
import cn.vonkun.core.core.SettingsFile;
import cn.vonkun.core.listeners.MainListener;
import cn.vonkun.core.menu.MenuAPI;
import cn.vonkun.core.menu.MenuImplementor;
import cn.vonkun.core.menu.MenuManager;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class NovCore extends JavaPlugin {
    private MenuImplementor menu;
    private SettingsFile settingsFile;
    @Override
    public void onEnable(){
        this.menu = new MenuImplementor();
        getServer().getPluginManager().registerEvents(new MenuManager(),this);
        getServer().getPluginManager().registerEvents(new MainListener(this),this);
        getServer().getServicesManager().register(MenuAPI.class,menu,this, ServicePriority.Normal);
        getCommand("novcore").setExecutor(new MainCommand(this));

        settingsFile = new SettingsFile("settings.yml",this);

        getLogger().info("NovCore成功启动");
    }

    public SettingsFile getSettingsFile() {
        return settingsFile;
    }
}
