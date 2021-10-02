package com.diu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: DIU
 * @Date: 2021/9/30 23:29
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    public static final String PAYMENTSRV_URL = "http://cloud-provider-payment";

    @RequestMapping(value = "/consumer/payment/zk")
    public String paymentzk() {
        return restTemplate.getForObject(PAYMENTSRV_URL + "/payment/zk", String.class);
    }

}
