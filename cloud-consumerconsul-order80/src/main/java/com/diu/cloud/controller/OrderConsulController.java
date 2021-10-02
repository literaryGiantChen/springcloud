package com.diu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: DIU
 * @Date: 2021/10/1 16:22
 */
@RestController
public class OrderConsulController {

    /**
     * cloud-provider-payment
     */
    public static final String INVOKE_URL = "http://consul-provider-payment";

    private final RestTemplate restTemplate;

    @Autowired
    public OrderConsulController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        System.out.println("消费者调用支付服务(consule)--->result:" + result);
        return result;
    }

}
