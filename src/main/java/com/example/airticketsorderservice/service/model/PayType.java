package com.example.airticketsorderservice.service.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PayType {
    WECHAT("WECHAT"),
    ALIPAY("ALIPAY"),
    UNIONPAY("UNIONPAY"),
    PRECHARGE("PRECHARGE");

    private final String value;

    PayType(String value) {
        this.value = value;
    }

    public static PayType from(String value) {
        return Arrays.stream(PayType.values())
                .filter(code -> code.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
