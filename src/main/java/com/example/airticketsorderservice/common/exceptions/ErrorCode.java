package com.example.airticketsorderservice.common.exceptions;

public enum ErrorCode {
    INVALID_USER_INFO("invalid_user_info"),
    INTERNAL_SERVER_ERROR("internal_server_error"),
    ORDER_NOT_FOUND("order_not_found"),
    ACCOUNT_NOT_ENOUGH("not_enough"),
    VISIT_CODE_NOT_FOUND("visit_code_not_found");

    private String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
