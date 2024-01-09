package org.plugin.bookedit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length == 1){
            List<String> options = new ArrayList<String>();
            options.add("anonymous");
            options.add("tattered");
            options.add("help");
            return options;
        }
        else{
            return new ArrayList<String>();
        }
    }
}
