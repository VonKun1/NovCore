package cn.vonkun.core.core;

import cn.vonkun.core.files.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SettingsFile extends FileManager {
    public SettingsFile(String filename, JavaPlugin plugin) {
        super(filename, plugin);
        setupFile();
    }
}
