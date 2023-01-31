package co.uvisuals.payments.config;

import eu.dkcode.configuration.annotations.ConfigurationFile;
import lombok.Data;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

@ConfigurationFile(
    file = "config.json",
    directory = "./plugins/uvisuals"
)
@Data
public class ApiConfig {

  private final String apiKey;
  private final String subServerId;
  private final DesignateType designateType;
  private final Long interval;

}
