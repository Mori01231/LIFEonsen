package onsen.onsen;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Vector;

public final class Onsen extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("onsen")) {
            if (!(sender instanceof Player)) return false;
            Player player = (Player) sender;
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("normal")) {
                    String data = this.getConfig().getString("normal");
                    String[] loc = data.split(",");
                    World world = Bukkit.getServer().getWorld(loc[0]);
                    double x = Double.parseDouble(loc[1]);
                    double y = Double.parseDouble(loc[2]);
                    double z = Double.parseDouble(loc[3]);
                    Location location = new Location(world, x, y, z);
                    player.teleport(location);
                    player.sendMessage(ChatColor.GOLD + "温泉へ移動しました。ゆっくり休んでね" + ChatColor.AQUA + "^w^");
                    return true;
                } else if (args[0].equalsIgnoreCase("lava")) {
                    String data = this.getConfig().getString("lava");
                    String[] loc = data.split(",");
                    World world = Bukkit.getServer().getWorld(loc[0]);
                    double x = Double.parseDouble(loc[1]);
                    double y = Double.parseDouble(loc[2]);
                    double z = Double.parseDouble(loc[3]);
                    Location location = new Location(world, x, y, z);
                    player.teleport(location);
                    player.sendMessage(ChatColor.DARK_RED + "溶岩温泉へ移動しました。ゆっくり休んでね" + ChatColor.DARK_PURPLE + "^w^");
                    return true;
                } else if (args[0].equalsIgnoreCase("ringo")) {
                    String data = this.getConfig().getString("ringo");
                    String[] loc = data.split(",");
                    World world = Bukkit.getServer().getWorld(loc[0]);
                    double x = Double.parseDouble(loc[1]);
                    double y = Double.parseDouble(loc[2]);
                    double z = Double.parseDouble(loc[3]);
                    Location location = new Location(world, x, y, z);
                    player.teleport(location);
                    player.sendMessage(ChatColor.GOLD + "リンゴ村温泉へ移動しました。ゆっくり休んでね" + ChatColor.AQUA + "^w^");
                    return true;
                } else if (args[0].equalsIgnoreCase("5bisi")) {
                    String data = this.getConfig().getString("5bisi");
                    String[] loc = data.split(",");
                    World world = Bukkit.getServer().getWorld(loc[0]);
                    double x = Double.parseDouble(loc[1]);
                    double y = Double.parseDouble(loc[2]);
                    double z = Double.parseDouble(loc[3]);
                    Location location = new Location(world, x, y, z);
                    player.teleport(location);
                    player.sendMessage(ChatColor.GOLD + "五菱温泉へ移動しました。ゆっくり休んでね" + ChatColor.AQUA + "^w^");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "正しいコマンドを入力してください" + ChatColor.WHITE + "例)/onsen normal");
                }
                return true;
            }
            return false;
        }

        if(cmd.getName().equalsIgnoreCase("setonsen")){
            if (args.length != 0) {
                if(args[0].equalsIgnoreCase("normal")){
                    if(!(sender instanceof Player)) return false;
                    if (sender.hasPermission("set.op")) {
                        Player player = (Player)sender;
                        Location loc = player.getLocation();
                        String world = loc.getWorld().getName();
                        int x = loc.getBlockX();
                        int y = loc.getBlockY();
                        int z = loc.getBlockZ();
                        this.getConfig().set("normal", world + "," + x + "," + y + "," + z);
                        this.saveConfig();
                        player.sendMessage("ノーマル温泉を登録しました");
                        return true;
                    }else{
                        sender.sendMessage("権限者のみ使えます");
                    }
                }
                if(args[0].equalsIgnoreCase("lava")) {
                    if (!(sender instanceof Player)) return false;
                    if (sender.hasPermission("set.op")) {
                        Player player = (Player) sender;
                        Location loc = player.getLocation();
                        String world = loc.getWorld().getName();
                        Vector v = new Vector();
                        int x = loc.getBlockX();
                        int y = loc.getBlockY();
                        int z = loc.getBlockZ();
                        this.getConfig().set("lava", world + "," + x + "," + y + "," + z);
                        this.saveConfig();
                        player.sendMessage("溶岩温泉を登録しました");
                    }else{
                        sender.sendMessage("権限者のみ使えます");
                    }
                }
                if(args[0].equalsIgnoreCase("ringo")) {
                    if (!(sender instanceof Player)) return false;
                    if (sender.hasPermission("set.op")) {
                        Player player = (Player) sender;
                        Location loc = player.getLocation();
                        String world = loc.getWorld().getName();
                        int x = loc.getBlockX();
                        int y = loc.getBlockY();
                        int z = loc.getBlockZ();
                        this.getConfig().set("ringo", world + "," + x + "," + y + "," + z);
                        this.saveConfig();
                        player.sendMessage("リンゴ村温泉を登録しました");
                    }else{
                        sender.sendMessage("権限者のみ使えます");
                    }
                }
                if(args[0].equalsIgnoreCase("5bisi")) {
                    if (!(sender instanceof Player)) return false;
                    if (sender.hasPermission("set.op")) {
                        Player player = (Player) sender;
                        Location loc = player.getLocation();
                        String world = loc.getWorld().getName();
                        int x = loc.getBlockX();
                        int y = loc.getBlockY();
                        int z = loc.getBlockZ();
                        this.getConfig().set("5bisi", world + "," + x + "," + y + "," + z);
                        this.saveConfig();
                        player.sendMessage("五菱温泉を登録しました");
                    }else{
                        sender.sendMessage("権限者のみ使えます");
                    }
                }
            }
        }
        return false;
    }
}
