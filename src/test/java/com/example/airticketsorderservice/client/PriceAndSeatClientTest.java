package com.example.airticketsorderservice.client;

import com.example.airticketsorderservice.client.dto.PriceAndSeatServiceRequest;
import com.example.airticketsorderservice.client.dto.PriceAndSeatServiceResponse;
import com.example.airticketsorderservice.common.OrderConstant;
import com.example.airticketsorderservice.configuration.FakeExternalServiceTestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceAndSeatClientTest extends FakeExternalServiceTestBase {

    @Autowired
    PriceAndSeatServiceClient priceAndSeatServiceClient;

    @Test
    @DisplayName("AC1-工序4")
    void should_lock_seat_success_when_create_order() throws JsonProcessingException, ParseException, TimeoutException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        PriceAndSeatServiceRequest requestBody = PriceAndSeatServiceRequest.builder()
                .flightNo("MU2022")
                .flightDate(sdf.parse("2022-03-12"))
                .quanatity(1)
                .build();

        PriceAndSeatServiceResponse responseBody = PriceAndSeatServiceResponse.builder().code(OrderConstant.LOCK_SEAT_SUCCESS_CODE).build();

        String body = objectMapper.writeValueAsString(responseBody);
        chargeCardWireMockServer.stubFor(WireMock.post("/take-flight/lock-seat")
                .willReturn(aResponse()
                        .withHeader("content-type", "application/json")
                        .withStatus(200)
                        .withBody(body)
                )
        );

        PriceAndSeatServiceResponse response = priceAndSeatServiceClient.lockSeat(requestBody);

        assertEquals(OrderConstant.LOCK_SEAT_SUCCESS_CODE, response.getCode());
    }

}
