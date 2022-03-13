package com.example.airticketsorderservice.client.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private int userId;
    private double amount;
    private String payType;

}
