package com.diu.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: DIU
 * @Date: 2021/10/5 14:07
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
