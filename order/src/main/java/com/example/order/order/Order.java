package com.example.order.order;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class Order {



    @GetMapping("getOrderId")
    String getUserOrder(){
        return "orderId 111";
    }
}
