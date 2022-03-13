package com.example.airticketsorderservice.service;

import com.example.airticketsorderservice.client.PaymentServiceClient;
import com.example.airticketsorderservice.client.PriceAndSeatServiceClient;
import com.example.airticketsorderservice.client.dto.PaymentRequest;
import com.example.airticketsorderservice.client.dto.PaymentResponse;
import com.example.airticketsorderservice.client.dto.PriceAndSeatServiceRequest;
import com.example.airticketsorderservice.client.dto.PriceAndSeatServiceResponse;
import com.example.airticketsorderservice.common.OrderConstant;
import com.example.airticketsorderservice.producer.MessageProducer;
import com.example.airticketsorderservice.producer.OrderMessage;
import com.example.airticketsorderservice.repository.OrderRepository;
import com.example.airticketsorderservice.service.mapper.OrderMapper;
import com.example.airticketsorderservice.service.model.OrderModel;
import com.example.airticketsorderservice.service.model.OrderStatus;
import com.example.airticketsorderservice.service.model.PayType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PriceAndSeatServiceClient priceAndSeatServiceClient;
    @Autowired
    PaymentServiceClient paymentServiceClient;
    @Autowired
    MessageProducer messageProducer;


    public String create(int unserId, String targetFlight, Date targetDate, double amount, int quantity){
        OrderModel order = OrderModel.builder().userId(unserId)
                .flightNo(targetFlight)
                .flightDate(targetDate)
                .quantity(quantity)
                .amount(amount)
                .orderStatus(OrderStatus.WAIT_PAYMENT)
                .payType(PayType.ALIPAY)
                .build();
        try{
            PriceAndSeatServiceResponse response = priceAndSeatServiceClient.lockSeat(PriceAndSeatServiceRequest.builder()
                    .flightNo(targetFlight)
                    .flightDate(targetDate)
                    .quanatity(quantity)
                    .build());
            if(OrderConstant.LOCK_SEAT_SUCCESS_CODE.equals(response.getCode())){
                orderRepository.save(OrderMapper.toEntity(order));
                return OrderConstant.SUCCESS_CODE + OrderConstant.ORDER_DELIMITER + OrderConstant.SUCCESS_MESSAGE;
            }
            return response.getCode() + OrderConstant.ORDER_DELIMITER + response.getMessage();
        } catch(TimeoutException e){
            log.error("server_error with message: {}", e.getMessage());
            return OrderConstant.SERVER_ERROR_CODE + OrderConstant.ORDER_DELIMITER + e.getMessage();
        }

    }

    public String payment(int orderId, int unserId, String payType, double amount){
        PaymentRequest request = PaymentRequest.builder().userId(unserId).payType(payType).amount(amount).build();
        PaymentResponse response = paymentServiceClient.payment(request);
        OrderModel orderModel = OrderMapper.toModel(orderRepository.findById(orderId));
        if(OrderConstant.PAYMENT_SUCCESS_CODE.equals(response.getCode())){
            orderModel.setOrderStatus(OrderStatus.PAYMENT_SUCCESS);
            this.sendMessage(orderModel);
        } else{
            orderModel.setOrderStatus(OrderStatus.PAYMENT_FAIL);
        }
        orderRepository.save(OrderMapper.toEntity(orderModel));
        return response.getCode() + OrderConstant.ORDER_DELIMITER + response.getMessage();
    }

    private void sendMessage(OrderModel order){
        String messageId = order.getId() + OrderConstant.ORDER_DELIMITER + new Date();
        messageProducer.sendOrderMessage(OrderMessage.builder().messageId(messageId).messageContent(order.toString()).build().toString());
    }
}
