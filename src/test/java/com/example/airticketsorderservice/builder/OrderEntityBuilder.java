package com.example.airticketsorderservice.builder;

import com.example.airticketsorderservice.repository.entity.OrderEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderEntityBuilder {

    private OrderEntity orderEntity = new OrderEntity();
}
