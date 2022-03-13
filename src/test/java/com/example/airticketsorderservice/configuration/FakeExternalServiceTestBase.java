package com.example.airticketsorderservice.configuration;

import com.example.airticketsorderservice.IntegrationTestBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.springframework.cloud.contract.wiremock.WireMockSpring.options;

public class FakeExternalServiceTestBase extends IntegrationTestBase {

    public static WireMockServer chargeCardWireMockServer;

    public ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void setUpForMockServer() {
        chargeCardWireMockServer = new WireMockServer(options().port(8089));
        chargeCardWireMockServer.start();
    }

    @BeforeEach
    void setUpEach(){
        chargeCardWireMockServer.resetAll();
    }

}
