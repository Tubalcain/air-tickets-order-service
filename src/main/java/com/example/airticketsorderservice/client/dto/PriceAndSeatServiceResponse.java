package com.example.airticketsorderservice.client.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceAndSeatServiceResponse {

    private String code;
    private String message;
}
