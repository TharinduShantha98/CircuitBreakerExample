package com.example.customer.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class customer {

    @Lazy
    private final RestTemplate restTemplate;
    private static  final String baseUrl = "http://localhost:8081/api/order/getOrderId";
    private static final String CUSTOMER_SERVICE = "customerService";
    private int  attempt = 1;



    @Autowired
    public customer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("getAllCustomer")
    String getAllCustomerDetail(){
        return "nimal";
    }


    @GetMapping("getOrderId")
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "getAllOrders")
    String getOrderId(){
        return restTemplate.getForObject(baseUrl,String.class);

    }

    public String getAllOrders(Exception e){
        return "this order service id :0011";
    }







}
