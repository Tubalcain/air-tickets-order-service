package com.example.airticketsorderservice.service.mapper;

import com.example.airticketsorderservice.repository.entity.OrderEntity;
import com.example.airticketsorderservice.service.model.OrderModel;
import com.example.airticketsorderservice.service.model.OrderStatus;
import com.example.airticketsorderservice.service.model.PayType;

public class OrderMapper {

    public static OrderModel toModel(OrderEntity order) {
        return OrderModel.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .flightNo(order.getFlightNo())
                .flightDate(order.getFlightDate())
                .orderStatus(OrderStatus.from(order.getOrderStatus()))
                .payType(PayType.from(order.getPayType()))
                .amount(order.getAmount())
                .ticketId(order.getTicketId())
                .invoiceId(order.getInvoiceId())
                .luggageId(order.getLuggageId())
                .originalOrderId(order.getOriginalOrderId())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();


    }

    public static OrderEntity toEntity(OrderModel order) {
        return OrderEntity.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .flightNo(order.getFlightNo())
                .flightDate(order.getFlightDate())
                .orderStatus(order.getOrderStatus().getValue())
                .payType(order.getPayType().getValue())
                .amount(order.getAmount())
                .ticketId(order.getTicketId())
                .invoiceId(order.getInvoiceId())
                .luggageId(order.getLuggageId())
                .originalOrderId(order.getOriginalOrderId())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }
}
