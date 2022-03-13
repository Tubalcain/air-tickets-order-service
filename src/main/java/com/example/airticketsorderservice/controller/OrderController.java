package com.example.airticketsorderservice.controller;

import com.example.airticketsorderservice.common.OrderConstant;
import com.example.airticketsorderservice.common.jwt.JwtUser;
import com.example.airticketsorderservice.controller.dto.OrderRequest;
import com.example.airticketsorderservice.controller.dto.OrderResponse;
import com.example.airticketsorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/flight/air-tickets")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/{id}/order")
    public OrderResponse create(@PathVariable long id,
                                JwtUser currentUser,
                                @RequestBody OrderRequest request){
        String msg = orderService.create(currentUser.getId(), request.getFlightNo(), request.getFlightDate(), request.getAmount(), request.getQuanatity());
        return msgHandler(msg);

    }

    @PostMapping("/{id}/order/payment")
    public OrderResponse payment(@PathVariable int id,
                           JwtUser currentUser,
                           @RequestBody OrderRequest request){
        String msg = orderService.payment(id, currentUser.getId(), request.getPayType(), request.getAmount());
        return msgHandler(msg);
    }

    private OrderResponse msgHandler(String msg){
        if(Objects.nonNull(msg)){
            return OrderResponse.builder().code(msg.split(OrderConstant.ORDER_DELIMITER)[0]).message(msg.split(OrderConstant.ORDER_DELIMITER)[1]).build();
        }
        return null;
    }
}
