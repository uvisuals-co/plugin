package co.uvisuals.payments;

import co.uvisuals.payments.config.DesignateType;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

@AllArgsConstructor
public class PaymentTask implements Runnable{

  private final PaymentService paymentService;
  private final DesignateType designateType;

  @Override
  public void run() {
    paymentService.checkPayments().thenAccept(payments -> {
      if(Objects.isNull(payments)) {
        System.out.println("Payments are null!");
        return;
      }

      List<String> designated = new ArrayList<>();
      payments.forEach(payment -> {
        switch (designateType){
          case COMMAND:
            Player player = Bukkit.getPlayer(payment.getPlayerName());
            if(Objects.isNull(player)) return;

            payment.getCommands().forEach(command -> {
              Bukkit.getScheduler().runTask(PaymentPlugin.getPlugin(PaymentPlugin.class), () -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("{NICKNAME}", payment.getPlayerName())));
              designated.add(payment.getId());
            });
            break;
          case EVENT:
            PaymentDesignateEvent paymentDesignateEvent = new PaymentDesignateEvent(payment);
            Bukkit.getScheduler().runTask(PaymentPlugin.getPlugin(PaymentPlugin.class), () -> Bukkit.getPluginManager().callEvent(paymentDesignateEvent));

            if(!paymentDesignateEvent.isCancelled()){
              designated.add(payment.getId());
            }
            break;
        }
      });
      paymentService.designate(designated);
    });
  }
}
