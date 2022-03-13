package com.example.airticketsorderservice.common.exceptions;

public class AccountNotEnoughException extends BaseConflictException {
    private static final long serialVersionUID = 3130677615686138367L;

    public AccountNotEnoughException() {
        super("可用余额不足，请检查");
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.ACCOUNT_NOT_ENOUGH;
    }
}
