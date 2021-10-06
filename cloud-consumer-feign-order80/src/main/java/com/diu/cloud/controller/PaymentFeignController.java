package com.diu.cloud.controller;

import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.pojo.Payment;
import com.diu.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: DIU
 * @Date: 2021/10/4 9:57
 */
@RestController
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        // 默认feign客户端只等待一秒钟,超过一秒钟,会导致feign不想等待了,就会报500异常
        // 避免这种情况发生,我们要设置feign客户端的超时时间.
        return paymentFeignService.paymentFeignTimeOut();
    }
}
