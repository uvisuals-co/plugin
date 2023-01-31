package co.uvisuals.payments;

import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

public class PaymentDesignateEvent extends Event implements Cancellable {

  @Getter private final Payment payment;

  public PaymentDesignateEvent(Payment payment) {
    this.payment = payment;
  }

  private static final HandlerList handlers = new HandlerList();

  private boolean cancelled;

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean b) {
    cancelled = b;
  }

  @Override
  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }
}
