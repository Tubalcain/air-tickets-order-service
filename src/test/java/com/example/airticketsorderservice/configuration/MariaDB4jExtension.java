package com.example.airticketsorderservice.configuration;

import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Objects;

public class MariaDB4jExtension implements BeforeAllCallback, AfterAllCallback {

    private static final int DEFAULT_PORT = 41306;

    private static MariaDB4jSpringService _mariaDB4jSpringService;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (Objects.nonNull(_mariaDB4jSpringService)) {
            return;
        }

        MariaDB4jSpringService mariaDB4jSpringService = new MariaDB4jSpringService();
        DBConfigurationBuilder dBConfigurationBuilder = mariaDB4jSpringService.getConfiguration();
        dBConfigurationBuilder.addArg("--character-set-server=utf8");
        dBConfigurationBuilder.addArg("--lower_case_table_names=1");
        dBConfigurationBuilder.addArg("--collation-server=utf8_general_ci");
        dBConfigurationBuilder.addArg("--max-connections=1024");
        dBConfigurationBuilder.addArg("--user=root");

        mariaDB4jSpringService.setDefaultPort(DEFAULT_PORT);

        try {
            mariaDB4jSpringService.start();
            _mariaDB4jSpringService = mariaDB4jSpringService;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Runtime.getRuntime()
               .addShutdownHook(
                       new Thread(
                               () -> {
                                   try {
                                       _mariaDB4jSpringService.stop();
                                   } catch (Exception e) {
                                       e.printStackTrace();
                                   }
                               }));
    }

    @Override
    public void afterAll(ExtensionContext context) {
    }

}
