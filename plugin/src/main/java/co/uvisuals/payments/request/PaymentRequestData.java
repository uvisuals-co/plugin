package co.uvisuals.payments.request;

import co.uvisuals.payments.Payment;

import java.util.List;
import java.util.Objects;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

public class PaymentRequestData {

    private final List<Payment> payments;

    public PaymentRequestData(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRequestData that = (PaymentRequestData) o;
        return Objects.equals(payments, that.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payments);
    }

    @Override
    public String toString() {
        return "PaymentRequestData{" +
               "payments=" + payments +
               '}';
    }
}
