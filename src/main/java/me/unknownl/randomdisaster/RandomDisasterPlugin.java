package me.unknownl.randomdisaster;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import javax.swing.text.html.parser.Entity;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.random;


public class RandomDisasterPlugin extends JavaPlugin {

    public static void start(CommandSender sender) {

        sender.sendMessage("Disaster started!");

        Player player = (Player) sender;
        //sleep()
        //Bukkit.getScheduler().runTaskLater(RandomDisaster.getPlugin(), start(sender), )

        Location playerLocation = player.getLocation();
        double X = playerLocation.getX();
        double Y = playerLocation.getY();
        double Z = playerLocation.getZ();





        //PotionEffect slowFallPot = new PotionEffect((PotionEffectType.SLOW_FALLING), 20, 1, true);

        Bukkit.getScheduler().runTaskTimer(RandomDisaster.getPlugin(), () -> trash(player, playerLocation), 0L, 200L);


/*
        Bukkit.getScheduler().runTaskTimer(RandomDisaster.getPlugin(), () -> {
            int dice5side = ThreadLocalRandom.current().nextInt(5);

            switch (dice5side) {
                case 0:
                    player.getWorld().createExplosion(X, Y - 2, Z, 7F);
                case 1:
                    trash(player, playerLocation);
                case 2:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 20 * 20, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 20, 2));
                case 3:
                    player.getWorld().spawn(playerLocation, Creeper.class);
                case 4:
                    player.getWorld().getBlockAt(playerLocation).setType(Material.WATER);


            }
        }, 20 * 15L, 20 * 15L);
*/


    }

    public static void stop(CommandSender sender) {
        Bukkit.getScheduler().cancelTasks(RandomDisaster.getPlugin());


        sender.sendMessage("Okay bro, I see you have enough haha");

    }

    public static void trash(Player player, Location playerLocation) {

        ItemStack ironBars = new ItemStack(Material.IRON_BARS);
        ItemStack cocabean = new ItemStack(Material.COCOA_BEANS);
        ItemStack ewdirt = new ItemStack(Material.COARSE_DIRT);

        for (int i = 0; i < 30; i++) {
            //int dice3side = (int) (Math.random() * 3); //random 0 - 2
            int dice3side = ThreadLocalRandom.current().nextInt(3);

            if (dice3side == 0) {
                player.getWorld().dropItem(playerLocation, ironBars);
            } else if (dice3side == 1) {
                player.getWorld().dropItem(playerLocation, cocabean);
            } else { //dice3side == 2
                player.getWorld().dropItem(playerLocation, ewdirt);
            }
        }

    }




}