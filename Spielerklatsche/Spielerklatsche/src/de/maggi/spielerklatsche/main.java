package de.maggi.spielerklatsche;

import java.io.File;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin implements Listener {
	
	public static File file = new File("plugins//Spielerklatsche//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	String name = "§3§lSpielerklatsche";
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	    this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		Inventory inv = createInv();
		
		if(cmd.getName().equalsIgnoreCase("Spielerklatsche")) {
			if(p.hasPermission("spielerklatsche.use")){
				if(args.length == 0) {
					p.sendMessage("§6§lDu hast die Spielerklatsche in deinem Inventar!");
					giveKlatsche(p);
					
				}
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("settings")) {
						p.openInventory(inv);
					}
				}
				
			}else {
				p.sendMessage("§4Du hast keine Rechte dazu!");
			}
          
					}
	
		return true;
  }
	
	public Inventory createInv() {
		
		ItemStack G = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta ig = G.getItemMeta();
		ig.setDisplayName("Platzhalter");
		G.setItemMeta(ig);
		
		ItemStack i = new ItemStack(Material.WATER_LILY, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName("§6§lStufe 1");
		i.setItemMeta(im);
		
		ItemStack i1 = new ItemStack(Material.WATER_LILY, 2);
		ItemMeta im1 = i1.getItemMeta();
		im1.setDisplayName("§6§lStufe 2");
		i1.setItemMeta(im1);
		
		ItemStack i2 = new ItemStack(Material.WATER_LILY, 3);
		ItemMeta im2 = i2.getItemMeta();
		im2.setDisplayName("§6§lStufe 3");
		i2.setItemMeta(im2);
		
		ItemStack i3 = new ItemStack(Material.WATER_LILY, 4);
		ItemMeta im3 = i3.getItemMeta();
		im3.setDisplayName("§6§lStufe 4");
		i3.setItemMeta(im3);

		
	    Inventory inv = Bukkit.createInventory(null, 9, "Wähle eine Stärke!"); 
	    inv.setItem(0, G);
		inv.setItem(1, i);
		inv.setItem(2, G);
		inv.setItem(3, i1);
		inv.setItem(4, G);
		inv.setItem(5, i2);
		inv.setItem(6, G);
		inv.setItem(7, i3);
		inv.setItem(8, G);
		return inv;
	}
	
	
	public void giveKlatsche(Player p) {
        Material material = Material.WATER_LILY;
        int ammount = 1;
        String name = "§6§lSpielerklatsche";
        ItemStack item = new ItemStack(material, ammount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList("Made by Maggihirn"));
        item.setItemMeta(itemMeta);
        p.getInventory().addItem(item);
	    
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		HumanEntity p = e.getWhoClicked();
		if(p.hasPermission("Spielerklatsche.use")){
		if(e.getInventory().getName().equalsIgnoreCase("Wähle eine Stärke!")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lStufe 1")) {
				this.getConfig();
				this.getConfig().set(p.getName() + ".strength", 1);
				this.saveConfig();
				p.sendMessage("§6§lDie Stärke wurde auf §71§6§l geändert!");
				e.setCancelled(true);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lStufe 2")){
				this.getConfig();
				this.getConfig().set(p.getName() + ".strength", 2);
				this.saveConfig();
				p.sendMessage("§6§lDie Stärke wurde auf §72§6§l geändert!");
				e.setCancelled(true);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lStufe 3")) {
				this.getConfig();
				this.getConfig().set(p.getName() + ".strength", 3);
				this.saveConfig();
				p.sendMessage("§6§lDie Stärke wurde auf §73§6§l geändert!");
				e.setCancelled(true);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lStufe 4")) {
				this.getConfig();
				this.getConfig().set(p.getName() + ".strength", 4);
				this.saveConfig();
				p.sendMessage("§6§lDie Stärke wurde auf §74§6§l geändert!");
				e.setCancelled(true);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Platzhalter")) {
				e.setCancelled(true);
			}
			
		}
		}
		
		
		}
	
	@EventHandler
	
	public void onInteract(PlayerInteractEvent e) {

		}
		
	@EventHandler
	public void onKlatsch(PlayerInteractEntityEvent e) {
		Player p = (Player) e.getRightClicked();
		Player d = (Player) e.getPlayer();
		this.reloadConfig();
		int multiplier = this.getConfig().getInt(d.getName() + ".strength");
		if(d.hasPermission("Spielerklatsche.use")){
		if(d.getInventory().getItemInMainHand().getType() == Material.WATER_LILY && d.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§6§lSpielerklatsche")){
			p.setVelocity(d.getLocation().getDirection().multiply(multiplier));
			d.sendMessage("§6§lDu hast§r " + p.getName() + " §6§lweggeklatscht!" );
			p.setFallDistance(0);
			p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_KNOCKBACK, 5, 15);
}
			
			
		}
	}
	
}