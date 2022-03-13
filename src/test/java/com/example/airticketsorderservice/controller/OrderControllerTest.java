package com.example.airticketsorderservice.controller;

import com.example.airticketsorderservice.IntegrationTestBase;
import com.example.airticketsorderservice.common.OrderConstant;
import com.example.airticketsorderservice.controller.dto.OrderRequest;
import com.example.airticketsorderservice.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.mockito.Mockito.when;

public class OrderControllerTest extends IntegrationTestBase {

    @MockBean
    private OrderService orderService;

    @Test
    @DisplayName("AC1-工序1")
    void should_return_success_when_create_ordre() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        OrderRequest request = OrderRequest.builder()
                .flightNo("MU2022")
                .flightDate(sdf.parse("2022-03-12"))
                .quanatity(1)
                .amount(2000)
                .build();

        when(orderService.create(1, "MU2022", sdf.parse("2022-03-12"), 2000, 1))
                .thenReturn(OrderConstant.SUCCESS_CODE);

        given().body(request)
                .post("/flight/air-tickets/0/order", 1)
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
