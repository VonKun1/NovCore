package cn.vonkun.core.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class FileManager implements Files{
    private final String filename;
    private final JavaPlugin plugin;
    private File file;
    private FileConfiguration fileConfig;

    public FileManager(String filename, JavaPlugin plugin) {
        this.filename = filename;
        this.plugin = plugin;
    }

    @Override
    public void setupFile() {
        this.file = new File(this.plugin.getDataFolder(),this.filename);
        if (!this.file.exists()) {
            this.plugin.saveResource(this.filename,false);
        }
        this.fileConfig = YamlConfiguration.loadConfiguration(this.file);
    }

    @Override public void setupFile(String parent) {
        File folder = new File(this.plugin.getDataFolder(), parent);
        this.file = new File(folder,this.filename);
        if (!this.file.exists()) {
            String resourcePath = parent + File.separator + this.filename;
            this.plugin.saveResource(resourcePath,false);
        }
        this.fileConfig = YamlConfiguration.loadConfiguration(this.file);
    }

    @Override
    public void reloadFile() {
        this.fileConfig = YamlConfiguration.loadConfiguration(this.file);
    }

    @Override
    public void saveFile() {
        if (this.file.exists()) {
            try {
                this.fileConfig.save(this.file);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public FileConfiguration getFile() {
        return this.fileConfig;
    }
}
