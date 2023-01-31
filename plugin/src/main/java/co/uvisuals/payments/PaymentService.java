package co.uvisuals.payments;

import co.uvisuals.payments.request.PaymentDesignateData;
import co.uvisuals.payments.request.PaymentRequestData;
import eu.dkcode.gson.Gson;
import lombok.AllArgsConstructor;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

@AllArgsConstructor
public class PaymentService {

  private final String apiKey;
  private final String subServerId;
  private final Gson gson;

  private final OkHttpClient client = new OkHttpClient();

  public CompletableFuture<List<Payment>> checkPayments(){
    return CompletableFuture.supplyAsync(() -> {
      Request request = new Request.Builder()
          .url("https://api.uvisuals.co/api/payments?subServerId=" + subServerId + "&apiKey=" + apiKey)
          .build();

      try {
        Response response = client.newCall(request).execute();
        if(response.code() != 200) return null;

        String body = response.body().string();
        PaymentRequestData paymentRequestData = gson.fromJson(body, PaymentRequestData.class);

        response.body().close();
        return paymentRequestData.getPayments();
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
    });
  }
  public static final MediaType JSON
      = MediaType.parse("application/json; charset=utf-8");

  public void designate(List<String> payment){
    CompletableFuture.runAsync(() -> {
      try {
        PaymentDesignateData paymentDesignateData = new PaymentDesignateData(apiKey, payment);

        String json = gson.toJson(paymentDesignateData);

        RequestBody body = RequestBody.create(
            json,
            JSON
        );

        Request request = new Request.Builder()
            .url("https://api.uvisuals.co/api/payments")
            .post(body)
            .build();

        Response response = client.newCall(request).execute();
        if(response.code() != 200) return;

        response.body().close();
      } catch (Exception e){
        e.printStackTrace();
      }
    });
  }


}
