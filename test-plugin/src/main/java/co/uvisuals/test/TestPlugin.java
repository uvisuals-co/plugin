package co.uvisuals.test;

import co.uvisuals.payments.PaymentDesignateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 23.01.2023
 **/

public class TestPlugin extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(this,this);
  }

  @EventHandler
  public void onPayment(PaymentDesignateEvent event){
    System.out.println("Payment designated! " + event.getPayment().getId());
    event.setCancelled(false);
  }

}
