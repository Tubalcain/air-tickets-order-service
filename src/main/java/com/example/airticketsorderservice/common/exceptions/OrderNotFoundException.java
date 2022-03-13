package com.example.airticketsorderservice.common.exceptions;

public class OrderNotFoundException extends BaseNotFoundException {
    private static final long serialVersionUID = 3130677615686138367L;

    public OrderNotFoundException() {
        super("订单不存在");
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.ORDER_NOT_FOUND;
    }
}
