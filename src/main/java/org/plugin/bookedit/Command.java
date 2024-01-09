package org.plugin.bookedit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class Command implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] args) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(args[0].equalsIgnoreCase("help")){
                p.sendMessage("help");
            } else {
                ItemStack item = p.getInventory().getItemInMainHand();
                if(item.getType() == Material.WRITTEN_BOOK){
                    BookMeta meta = (BookMeta) item.getItemMeta();
                    if(meta.getAuthor().equals(p.getName())){

                        if (args[0].equalsIgnoreCase("anonymous")){
                            meta.setAuthor("Anonymous");
                            item.setItemMeta(meta);
                        } else if (args[0].equalsIgnoreCase("tattered")) {
                            meta.setGeneration(BookMeta.Generation.TATTERED);
                            item.setItemMeta(meta);
                        }
                        else{
                            p.sendMessage(ChatColor.RED + "Incorrect command");
                        }

                    }
                    else {
                        p.sendMessage(ChatColor.RED + "The book needs to be yours");
                    }
                }
                else{
                    p.sendMessage(ChatColor.RED + "The signed book needs to be in your hand");
                }
            }
        }

        return true;
    }
}
