package cn.vonkun.core.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public interface Files {
    void setupFile();
    void setupFile(String parent);
    void reloadFile();
    void saveFile();
    FileConfiguration getFile();
}
