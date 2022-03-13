package com.example.airticketsorderservice.controller.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String flightNo;
    private Date flightDate;
    private double amount;
    private int quanatity;
    private String payType;
}
