package com.diu.cloud.service.impl;

import com.diu.cloud.dao.PaymentDao;
import com.diu.cloud.pojo.Payment;
import com.diu.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: DIU
 * @Date: 2021/9/29 9:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        if (id <= 0) {
            return null;
        }
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }
}
