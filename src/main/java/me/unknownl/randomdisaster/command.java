package me.unknownl.randomdisaster;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class command implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            if (args.length > 1) {
                return false;
            }

            if (args.length == 1) {
                if (args[0].equals("start")) {
                    //start disaster
                    RandomDisasterPlugin.start(sender);
                } else if (args[0].equals("stop")) {
                    RandomDisasterPlugin.stop(sender);
                } else {
                    sender.sendMessage("Error: command syntax, start or stop");
                    return false;
                }

            }

            return true;
        }
        return true;
    }

}
