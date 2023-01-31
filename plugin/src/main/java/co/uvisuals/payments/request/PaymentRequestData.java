package co.uvisuals.payments.request;

import co.uvisuals.payments.Payment;
import lombok.Data;

import java.util.ArrayList;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

@Data
public class PaymentRequestData {

  private final ArrayList<Payment> payments;

}
