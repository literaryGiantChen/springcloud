package com.diu.cloud.service;

import com.diu.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author DIU
 * @date 2021/9/29 9:40
 */
public interface PaymentService {

    public int creat(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public int update(Payment payment);

}
