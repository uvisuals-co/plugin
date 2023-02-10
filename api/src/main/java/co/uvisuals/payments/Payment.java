package co.uvisuals.payments;


import java.util.List;
import java.util.Objects;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/


public class Payment {

    private final String id;
    private final String playerName;
    private final String variant;
    private final List<String> commands;


    public Payment(String id, String playerName, String variant, List<String> commands) {
        this.id = id;
        this.playerName = playerName;
        this.variant = variant;
        this.commands = commands;
    }


    public String getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getVariant() {
        return variant;
    }

    public List<String> getCommands() {
        return commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(playerName, payment.playerName) && Objects.equals(variant, payment.variant) && Objects.equals(commands, payment.commands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerName, variant, commands);
    }

    @Override
    public String toString() {
        return "Payment{" +
               "id='" + id + '\'' +
               ", playerName='" + playerName + '\'' +
               ", variant='" + variant + '\'' +
               ", commands=" + commands +
               '}';
    }
}
