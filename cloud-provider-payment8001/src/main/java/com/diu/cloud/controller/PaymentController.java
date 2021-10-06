package com.diu.cloud.controller;

import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.pojo.Payment;
import com.diu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: DIU
 * @Date: 2021/9/29 9:45
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value(value = "${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.creat(payment);
        log.info("***************插入数据结果：{}***************", result);

        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据成功", result);
        } else {
            return new CommonResult<Integer>(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***************查询数据结果：{}***************", payment);

        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功 serverPort: " + this.serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "没有对应的记录, 查询ID: " + id, null);
        }
    }

    @PostMapping(value = "/update")
    public CommonResult<Integer> update(@RequestBody Payment payment) {
        int result = paymentService.update(payment);
        log.info("***************修改数据结果：{}***************", result);

        if (result > 0) {
            return new CommonResult<Integer>(200, "修改数据成功", result);
        } else {
            return new CommonResult<Integer>(444, "修改数据失败", null);
        }
    }

    /**
     * 获取端口号
     *
     * @return 返回端口号
     */
    @GetMapping(value = "/lb")
    public String getServerPort() {
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeOut() {
        log.info("*****paymentFeignTimeOut from port: {}*****", serverPort);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
