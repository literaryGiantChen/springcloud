package com.diu.cloud.service;

import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @author DIU
 * @date 2021/10/14 9:57
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回,没有该流水信息", new Payment(id, "errorSerial......"));
    }
    
}
