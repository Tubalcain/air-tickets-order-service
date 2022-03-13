package com.example.airticketsorderservice.service.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrderStatus {
    WAIT_PAYMENT("WAIT_PAYMENT"),
    PAYMENT_SUCCESS("PAYMENT_SUCCESS"),
    PAYMENT_FAIL("PAYMENT_FAIL"),
    CHANGE_SUSSESS("CHANGE_SUSSESS"),
    CANCEL("CANCEL");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public static OrderStatus from(String value) {
        return Arrays.stream(OrderStatus.values())
                .filter(code -> code.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
