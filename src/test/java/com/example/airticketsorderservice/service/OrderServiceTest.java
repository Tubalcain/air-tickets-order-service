package com.example.airticketsorderservice.service;

import com.example.airticketsorderservice.client.PriceAndSeatServiceClient;
import com.example.airticketsorderservice.client.dto.PriceAndSeatServiceResponse;
import com.example.airticketsorderservice.common.OrderConstant;
import com.example.airticketsorderservice.configuration.MockitoExtension;
import com.example.airticketsorderservice.repository.OrderRepository;
import com.example.airticketsorderservice.repository.entity.OrderEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;
    @Mock
    PriceAndSeatServiceClient priceAndSeatServiceClient;

    @Test
    @DisplayName("AC1-工序2")
    void should_return_success_when_create_ordre() throws ParseException, TimeoutException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

        when(priceAndSeatServiceClient.lockSeat(any()))
                .thenReturn(PriceAndSeatServiceResponse.builder().code(OrderConstant.LOCK_SEAT_SUCCESS_CODE).build());

        when(orderRepository.save(any())).thenReturn(OrderEntity.builder().id(1).build());

        String msg = orderService.create(1, "MU2022", sdf.parse("2022-03-12"), 2000, 1);
        assertEquals(OrderConstant.SUCCESS_CODE + OrderConstant.ORDER_DELIMITER + OrderConstant.SUCCESS_MESSAGE, msg);
    }
}
