package org.plugin.bookedit;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BookEdit extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        Objects.requireNonNull(getCommand("book")).setExecutor(new Command());
        getCommand("book").setTabCompleter(new TabComplete());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void BookEvent(PlayerEditBookEvent event){
        BookMeta bookMeta = event.getNewBookMeta();



        int i = 1;
        for(String page : bookMeta.getPages()){
            page = page.replace("<b>", "" + ChatColor.BOLD);
            page = page.replace("<i>", "" + ChatColor.ITALIC);
            page = page.replace("<u>", "" + ChatColor.UNDERLINE);
            page = page.replace("<rn>", "" + ChatColor.MAGIC);

            page = page.replace("<ca>", "" + ChatColor.AQUA);
            page = page.replace("<cb>", "" + ChatColor.BLUE);
            page = page.replace("<cda>", "" + ChatColor.DARK_AQUA);
            page = page.replace("<cdb>", "" + ChatColor.DARK_BLUE);
            page = page.replace("<cdg>", "" + ChatColor.DARK_GRAY);
            page = page.replace("<cdgn>", "" + ChatColor.DARK_GREEN);
            page = page.replace("<cdp>", "" + ChatColor.DARK_PURPLE);
            page = page.replace("<cdr>", "" + ChatColor.DARK_RED);
            page = page.replace("<co>", "" + ChatColor.GOLD);
            page = page.replace("<cg>", "" + ChatColor.GRAY);
            page = page.replace("<cgn>", "" + ChatColor.GREEN);
            page = page.replace("<cp>", "" + ChatColor.LIGHT_PURPLE);
            page = page.replace("<cr>", "" + ChatColor.RED);
            page = page.replace("<cw>", "" + ChatColor.WHITE);
            page = page.replace("<cy>", "" + ChatColor.YELLOW);

            page = page.replace("<r>", "" + ChatColor.RESET);
            bookMeta.setPage(i, page);
            i++;
        }
        event.setNewBookMeta(bookMeta);
    }
}
