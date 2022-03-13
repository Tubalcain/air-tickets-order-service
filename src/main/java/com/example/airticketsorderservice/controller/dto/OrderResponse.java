package com.example.airticketsorderservice.controller.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private String code;
    private String message;
    private OrderDTO orderDTO;
}
