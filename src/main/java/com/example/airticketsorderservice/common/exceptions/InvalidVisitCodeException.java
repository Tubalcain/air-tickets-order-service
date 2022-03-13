package com.example.airticketsorderservice.common.exceptions;

public class InvalidVisitCodeException extends BaseUnauthorizedException {
    private static final long serialVersionUID = 4449660254133844486L;

    public InvalidVisitCodeException() {
        super("邀请码不存在，请检查！");
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.VISIT_CODE_NOT_FOUND;
    }
}
