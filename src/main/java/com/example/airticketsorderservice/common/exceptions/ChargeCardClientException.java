package com.example.airticketsorderservice.common.exceptions;

public class ChargeCardClientException extends BaseInternalServerException {
    private static final long serialVersionUID = 3130677615686138367L;

    public ChargeCardClientException() {
        super("资金委托管理功能异常，请联系管理员");
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.INTERNAL_SERVER_ERROR;
    }
}
