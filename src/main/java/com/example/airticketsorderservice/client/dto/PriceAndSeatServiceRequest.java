package com.example.airticketsorderservice.client.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceAndSeatServiceRequest {

    private String flightNo;
    private Date flightDate;
    private int quanatity;
}
