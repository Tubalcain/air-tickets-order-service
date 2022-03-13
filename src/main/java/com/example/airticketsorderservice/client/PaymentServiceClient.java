package com.example.airticketsorderservice.client;

import com.example.airticketsorderservice.client.dto.PaymentRequest;
import com.example.airticketsorderservice.client.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${feign.payment-service.name:payment-service}", url = "${feign.payment-service.url:http://payment-service:8080}")
public interface PaymentServiceClient {

    @PostMapping("/payment/payment")
    PaymentResponse payment(@RequestBody PaymentRequest request);
    @PostMapping("/payment/refund")
    PaymentResponse refund(@RequestBody PaymentRequest request);
}
