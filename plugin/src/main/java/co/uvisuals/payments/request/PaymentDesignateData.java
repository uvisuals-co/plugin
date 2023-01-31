package co.uvisuals.payments.request;

import lombok.Data;

import java.util.List;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

@Data
public class PaymentDesignateData {

  private final String apiKey;
  private final List<String> transactionIds;

}
