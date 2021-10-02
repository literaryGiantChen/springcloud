package com.diu.cloud.controller;

import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: DIU
 * @Date: 2021/9/29 20:26
 */
@RestController
@Slf4j
public class OrderController {

    private final RestTemplate restTemplate;
    /**
     * 单机版 生产者固定一个，没有通过eureka去轮询访问生产者
     */
    // public static final String PAYMENTSRV_URL = "http://localhost:8001";

    /**
     * 集群版 通过eureka去轮询访问资源，
     * 注意的是 生产者spring的application的name,要一致
     */
    public static final String PAYMENTSRV_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        log.info("123");
        return restTemplate.postForObject(PAYMENTSRV_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get_object/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYMENTSRV_URL + "/payment/get/" + id, CommonResult.class);
    }

    @PostMapping(value = "/consumer/payment/update")
    public CommonResult<Integer> update(Payment payment) {
        return restTemplate.postForObject(PAYMENTSRV_URL + "/payment/update", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get_entity/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENTSRV_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult(444, "请求的参数或者地址有误!!!");
        }
    }

}
