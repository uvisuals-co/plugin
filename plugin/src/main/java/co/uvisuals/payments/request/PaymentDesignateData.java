package co.uvisuals.payments.request;


import java.util.List;
import java.util.Objects;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

public class PaymentDesignateData {

    private final String apiKey;
    private final List<String> transactionIds;

    public PaymentDesignateData(String apiKey, List<String> transactionIds) {
        this.apiKey = apiKey;
        this.transactionIds = transactionIds;
    }

    public String getApiKey() {
        return apiKey;
    }

    public List<String> getTransactionIds() {
        return transactionIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDesignateData that = (PaymentDesignateData) o;
        return Objects.equals(apiKey, that.apiKey) && Objects.equals(transactionIds, that.transactionIds);
    }

    @Override
    public String toString() {
        return "PaymentDesignateData{" +
               "apiKey='" + apiKey + '\'' +
               ", transactionIds=" + transactionIds +
               '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, transactionIds);
    }
}
