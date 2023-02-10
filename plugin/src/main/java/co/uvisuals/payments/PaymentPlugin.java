package co.uvisuals.payments;

import co.uvisuals.payments.config.ApiConfig;
import co.uvisuals.payments.config.DesignateType;
import eu.dkcode.configuration.ConfigLoader;
import eu.dkcode.configuration.exceptions.UnAnnotatedException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

public class PaymentPlugin extends JavaPlugin {

    private final ConfigLoader configLoader = new ConfigLoader();
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private ApiConfig apiConfig;
    private PaymentService paymentService;

    @Override
    public void onEnable() {
        try {
            this.apiConfig = configLoader.load(ApiConfig.class, new ApiConfig("USTAW_W_CONFIGU_ZIOMEK", "USTAW_W_CONFIGU_ZIOMEK", DesignateType.COMMAND, 1000L));
        } catch (UnAnnotatedException | IOException e) {
            throw new RuntimeException(e);
        }
        this.paymentService = new PaymentService(this.apiConfig.getApiKey(), this.apiConfig.getSubServerId(), this.configLoader.getGsonBuilder().create());

        this.executorService.scheduleAtFixedRate(new PaymentTask(this.paymentService, this.apiConfig.getDesignateType()), 10000, this.apiConfig.getInterval(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void onDisable() {
        executorService.shutdown();
    }

}
