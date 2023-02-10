import co.uvisuals.payments.Payment;
import co.uvisuals.payments.PaymentService;
import eu.dkcode.configuration.ConfigLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

public class PaymentServiceTest {

    public static void main(String[] args) {

        ConfigLoader configLoader = new ConfigLoader();
        PaymentService paymentService = new PaymentService(
                "f2647f37f85c6f4afe9d4edfeefbd2",
                "56xvvvqar1nysmc",
                configLoader.getGsonBuilder().create()
        );

        List<String> p = new ArrayList<>();
        List<Payment> payments = paymentService.checkPayments().join();
        payments.forEach(payment -> {
            p.add(payment.getId());
        });

        paymentService.designate(p);


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
