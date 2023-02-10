package co.uvisuals.payments.config;

import eu.dkcode.configuration.annotations.ConfigurationFile;

import java.util.Objects;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

@ConfigurationFile(
        file = "config.json",
        directory = "./plugins/uvisuals"
)
public class ApiConfig {

    private final String apiKey;
    private final String subServerId;
    private final DesignateType designateType;
    private final Long interval;

    public ApiConfig(String apiKey, String subServerId, DesignateType designateType, Long interval) {
        this.apiKey = apiKey;
        this.subServerId = subServerId;
        this.designateType = designateType;
        this.interval = interval;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSubServerId() {
        return subServerId;
    }

    public DesignateType getDesignateType() {
        return designateType;
    }

    public Long getInterval() {
        return interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiConfig apiConfig = (ApiConfig) o;
        return Objects.equals(apiKey, apiConfig.apiKey) && Objects.equals(subServerId, apiConfig.subServerId) && designateType == apiConfig.designateType && Objects.equals(interval, apiConfig.interval);
    }

    @Override
    public String toString() {
        return "ApiConfig{" +
               "apiKey='" + apiKey + '\'' +
               ", subServerId='" + subServerId + '\'' +
               ", designateType=" + designateType +
               ", interval=" + interval +
               '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, subServerId, designateType, interval);
    }
}
