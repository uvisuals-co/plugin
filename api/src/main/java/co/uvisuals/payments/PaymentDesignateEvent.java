package co.uvisuals.payments;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

public class PaymentDesignateEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Payment payment;
    private boolean cancelled;

    public PaymentDesignateEvent(Payment payment) {
        this.payment = payment;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

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

    public Payment getPayment() {
        return payment;
    }
}
