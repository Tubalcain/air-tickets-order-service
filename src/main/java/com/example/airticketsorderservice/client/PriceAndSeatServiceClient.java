package com.example.airticketsorderservice.client;

import com.example.airticketsorderservice.client.dto.PriceAndSeatServiceRequest;
import com.example.airticketsorderservice.client.dto.PriceAndSeatServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.TimeoutException;

@FeignClient(name = "${feign.price-seat-service.name:price-seat-service}", url = "${feign.price-seat-service.url:http://localhost:8089}")
public interface PriceAndSeatServiceClient {

    @PostMapping("/take-flight/lock-seat")
    PriceAndSeatServiceResponse lockSeat(@RequestBody PriceAndSeatServiceRequest request) throws TimeoutException;
}
