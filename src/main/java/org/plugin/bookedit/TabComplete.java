package org.plugin.bookedit;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            List<String> options = new ArrayList<String>();
            if (args.length == 1) {

                options.add("anonymous");
                options.add("tattered");
                options.add("help");
                options.add("link");
                return options;
            } else if (args.length == 2 && args[0].equalsIgnoreCase("link")) {
                ItemStack item = p.getInventory().getItemInMainHand();
                if(item.getType() == Material.WRITABLE_BOOK){
                    BookMeta meta = (BookMeta) item.getItemMeta();
                    List<String> pages = meta.getPages();
                    for (String page : pages){
                        String[] page_splited = page.split("<a>");
                        for(int i = 0; i < page_splited.length; i++){
                            if(i%2 != 0){
                                options.add(page_splited[i]);
                            }
                        }
                    }
                    return options;
                }
            }

        }
        return new ArrayList<>();
    }
}
