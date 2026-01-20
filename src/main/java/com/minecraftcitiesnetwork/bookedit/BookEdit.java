package com.minecraftcitiesnetwork.bookedit;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class BookEdit extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void BookEvent(PlayerEditBookEvent event){
        BookMeta bookMeta = event.getNewBookMeta();

        int i = 1;
        for(String page : bookMeta.getPages()){
            // Convert legacy color codes to MiniMessage tags first
            String pageWithTags = convertLegacyToMiniMessage(page);
            
            // Convert MiniMessage tags to ChatColor codes
            String legacyText = convertToChatColor(pageWithTags);
            bookMeta.setPage(i, legacyText);
            i++;
        }
        
        event.setNewBookMeta(bookMeta);
    }

    private String convertLegacyToMiniMessage(String text) {
        // First convert & codes to § codes (Bukkit shorthand)
        text = text.replace("&l", "§l");
        text = text.replace("&o", "§o");
        text = text.replace("&n", "§n");
        text = text.replace("&m", "§m");
        text = text.replace("&k", "§k");
        text = text.replace("&r", "§r");
        text = text.replace("&0", "§0");
        text = text.replace("&1", "§1");
        text = text.replace("&2", "§2");
        text = text.replace("&3", "§3");
        text = text.replace("&4", "§4");
        text = text.replace("&5", "§5");
        text = text.replace("&6", "§6");
        text = text.replace("&7", "§7");
        text = text.replace("&8", "§8");
        text = text.replace("&9", "§9");
        text = text.replace("&a", "§a");
        text = text.replace("&b", "§b");
        text = text.replace("&c", "§c");
        text = text.replace("&d", "§d");
        text = text.replace("&e", "§e");
        text = text.replace("&f", "§f");
        
        // Convert legacy formatting codes to MiniMessage tags
        text = text.replace("§l", "<bold>");
        text = text.replace("§o", "<italic>");
        text = text.replace("§n", "<underlined>");
        text = text.replace("§m", "<strikethrough>");
        text = text.replace("§k", "<obfuscated>");
        text = text.replace("§r", "<reset>");
        
        // Convert legacy color codes to MiniMessage tags
        text = text.replace("§0", "<black>");
        text = text.replace("§1", "<dark_blue>");
        text = text.replace("§2", "<dark_green>");
        text = text.replace("§3", "<dark_aqua>");
        text = text.replace("§4", "<dark_red>");
        text = text.replace("§5", "<dark_purple>");
        text = text.replace("§6", "<gold>");
        text = text.replace("§7", "<gray>");
        text = text.replace("§8", "<dark_gray>");
        text = text.replace("§9", "<blue>");
        text = text.replace("§a", "<green>");
        text = text.replace("§b", "<aqua>");
        text = text.replace("§c", "<red>");
        text = text.replace("§d", "<light_purple>");
        text = text.replace("§e", "<yellow>");
        text = text.replace("§f", "<white>");
        
        return text;
    }

    private String convertToChatColor(String text) {
        // Formatting - MiniMessage style
        text = text.replace("<bold>", "" + ChatColor.BOLD);
        text = text.replace("<b>", "" + ChatColor.BOLD);
        text = text.replace("<italic>", "" + ChatColor.ITALIC);
        text = text.replace("<i>", "" + ChatColor.ITALIC);
        text = text.replace("<underlined>", "" + ChatColor.UNDERLINE);
        text = text.replace("<u>", "" + ChatColor.UNDERLINE);
        text = text.replace("<strikethrough>", "" + ChatColor.STRIKETHROUGH);
        text = text.replace("<st>", "" + ChatColor.STRIKETHROUGH);
        text = text.replace("<obfuscated>", "" + ChatColor.MAGIC);
        text = text.replace("<obf>", "" + ChatColor.MAGIC);

        // Colors - MiniMessage style, handle longer tags first to avoid conflicts
        text = text.replace("<dark_green>", "" + ChatColor.DARK_GREEN);
        text = text.replace("<dark_purple>", "" + ChatColor.DARK_PURPLE);
        text = text.replace("<dark_red>", "" + ChatColor.DARK_RED);
        text = text.replace("<dark_blue>", "" + ChatColor.DARK_BLUE);
        text = text.replace("<dark_aqua>", "" + ChatColor.DARK_AQUA);
        text = text.replace("<dark_gray>", "" + ChatColor.DARK_GRAY);
        text = text.replace("<dark_grey>", "" + ChatColor.DARK_GRAY);
        text = text.replace("<light_purple>", "" + ChatColor.LIGHT_PURPLE);
        text = text.replace("<red>", "" + ChatColor.RED);
        text = text.replace("<blue>", "" + ChatColor.BLUE);
        text = text.replace("<green>", "" + ChatColor.GREEN);
        text = text.replace("<aqua>", "" + ChatColor.AQUA);
        text = text.replace("<yellow>", "" + ChatColor.YELLOW);
        text = text.replace("<white>", "" + ChatColor.WHITE);
        text = text.replace("<black>", "" + ChatColor.BLACK);
        text = text.replace("<gold>", "" + ChatColor.GOLD);
        text = text.replace("<gray>", "" + ChatColor.GRAY);
        text = text.replace("<grey>", "" + ChatColor.GRAY);
        text = text.replace("<purple>", "" + ChatColor.LIGHT_PURPLE);
        text = text.replace("<pink>", "" + ChatColor.LIGHT_PURPLE);

        // Reset
        text = text.replace("<reset>", "" + ChatColor.RESET);
        text = text.replace("<r>", "" + ChatColor.RESET);
        
        return text;
    }
}
