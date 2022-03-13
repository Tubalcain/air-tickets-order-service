package com.example.airticketsorderservice.service.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    private int id;
    private int userId;
    private String flightNo;
    private Date flightDate;
    private int quantity;
    private OrderStatus orderStatus;
    private PayType payType;
    private double amount;
    private int ticketId;
    private int invoiceId;
    private int luggageId;
    private int originalOrderId;
    private Date createdAt;
    private Date updatedAt;
}
