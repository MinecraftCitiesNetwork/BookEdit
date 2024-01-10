package org.plugin.bookedit;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.C;

import java.awt.*;
import java.util.List;

public class Command implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] args) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            ItemStack item = p.getInventory().getItemInMainHand();
            if(args[0].equalsIgnoreCase("help")){
                p.sendMessage("To add effect or a color to a part of text in the book put one of those in front of the part you want to apply it to:\n" +
                        "<b> - " + ChatColor.BOLD + "BOLD\n" + ChatColor.RESET +
                        "<i> - " + ChatColor.ITALIC + "ITALIC\n" + ChatColor.RESET +
                        "<u> - " + ChatColor.UNDERLINE + "UNDERLINE\n" + ChatColor.RESET +
                        "<rn> - " + ChatColor.MAGIC + "RANDOM\n" + ChatColor.RESET +
                        "<ca> - " + ChatColor.AQUA + "AQUA\n" + ChatColor.RESET +
                        "<cb> - " + ChatColor.BLUE + "BLUE\n" + ChatColor.RESET +
                        "<cda> - " + ChatColor.DARK_AQUA + "DARK AQUA\n" + ChatColor.RESET +
                        "<cdb> - " + ChatColor.DARK_BLUE + "DARK BLUE\n" + ChatColor.RESET +
                        "<cdg> - " + ChatColor.DARK_GRAY + "DARK GRAY\n" + ChatColor.RESET +
                        "<cdgn> - " + ChatColor.DARK_GREEN + "DARK GREEN\n" + ChatColor.RESET +
                        "<cdp> - " + ChatColor.DARK_PURPLE + "DARK PURPLE\n" + ChatColor.RESET +
                        "<cdr> - " + ChatColor.DARK_RED + "DARK RED\n" + ChatColor.RESET +
                        "<co> - " + ChatColor.GOLD + "ORANGE\n" + ChatColor.RESET +
                        "<cg> - " + ChatColor.GRAY + "GRAY\n" + ChatColor.RESET +
                        "<cgn> - " + ChatColor.GREEN + "GREEN\n" + ChatColor.RESET +
                        "<cp> - " + ChatColor.LIGHT_PURPLE + "PINK\n" + ChatColor.RESET +
                        "<cr> - " + ChatColor.RED + "RED\n" + ChatColor.RESET +
                        "<cw> - " + ChatColor.WHITE + "WHITE\n" + ChatColor.RESET +
                        "<cy> = " + ChatColor.YELLOW + "YELLOW\n" + ChatColor.RESET +
                        "\n" +
                        "To stop the effect use - <r>" +
                        "\n" +
                        ChatColor.RED + "NOTE: IF YOU WANT TO COMBINE A COLOR WITH EFFECT(EXAMPLE: BOLD AND RED) ALWAYS ADD THE EFFECT AFTER THE COLOR(EXAMPLE: <cr><b>text) ");


            } else if (args[0].equalsIgnoreCase("anonymous")) {

                if(item.getType() == Material.WRITTEN_BOOK){
                    BookMeta meta = (BookMeta) item.getItemMeta();
                    if(meta.getAuthor().equals(p.getName())){
                        meta.setAuthor("Anonymous");
                        item.setItemMeta(meta);
                        p.sendMessage("The author is now anonymous");
                    }
                    else {
                        p.sendMessage(ChatColor.RED + "The book needs to be yours");
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED + "The signed book needs to be in your hand");
                }



            } else if (args[0].equalsIgnoreCase("tattered")) {

                if(item.getType() == Material.WRITTEN_BOOK){
                    BookMeta meta = (BookMeta) item.getItemMeta();
                    if(meta.getAuthor().equals(p.getName())){
                        meta.setGeneration(BookMeta.Generation.TATTERED);
                        item.setItemMeta(meta);
                        p.sendMessage("The book is now tattered");
                    }
                    else {
                        p.sendMessage(ChatColor.RED + "The book needs to be yours");
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED + "The signed book needs to be in your hand");
                }

            }
        }
        return true;
    }
}
