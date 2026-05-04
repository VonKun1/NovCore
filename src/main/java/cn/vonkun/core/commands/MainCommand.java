package cn.vonkun.core.commands;

import cn.vonkun.core.NovCore;
import cn.vonkun.core.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    private final NovCore plugin;

    public MainCommand(NovCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0)return true;
            if (args.length == 1){
                String arg = args[0];
                if (arg.equalsIgnoreCase("reload")){
                    FileConfiguration settings = plugin.getSettingsFile().getFile();
                    plugin.getSettingsFile().reloadFile();
                    ChatUtil.msg(p,settings.getString("reload"));
                }
            }
        }

        return false;
    }
}
