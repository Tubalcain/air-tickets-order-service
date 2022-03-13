package com.example.airticketsorderservice.common;

public class OrderConstant {

    public static String PAYMENT_SUCCESS_CODE = "PAYMENT_SUCCESS";
    public static String PAYMENT_SUCCESS_MESSAGE = "机票订购成功，将在60分钟内完成出票";
    public static String PAYMENT_FAIL_CODE = "PAYMENT_FAIL";
    public static String PAYMENT_FAIL_MESSAGE = "支付失败，";


    public static String LOCK_SEAT_SUCCESS_CODE = "LOCK_SEAT_SUCCESS";
    public static String LOCK_SEAT_FAIL_CODE = "LOCK_SEAT_FAIL";



    public static String SUCCESS_CODE = "SUCCESS";
    public static String SUCCESS_MESSAGE = "机票预订成功，请在30分钟内完成支付";
    public static String NO_ENOUGH_SEAT_CODE = "NO_ENOUGH_SEAT";
    public static String NO_ENOUGH_SEAT_MESSAGE = "该航班机票不足，请选择其他航班";
    public static String SERVER_ERROR_CODE = "SERVER_ERROR";
    public static String SERVER_ERROR_MESSAGE = "系统繁忙，请稍后再试";

    public static String ORDER_DELIMITER = "-";

}
