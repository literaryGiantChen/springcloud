package com.diu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.pojo.Payment;
import com.diu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author DIU
 * @date 2021/10/13 22:44
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 页面返回json：MediaType.APPLICATION_JSON_VALUE、application/json;charset=UTF-8
     * 页面返回xml：produces = MediaType.APPLICATION_XML_VALUE
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/consumer/fallback/{id}", produces = "application/json;charset=UTF-8")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback", //
            blockHandler = "blockHandler") //
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    // 代码体出现异常数调用这个兜底方法
    // 但是出现：exceptionsToIgnore = {IllegalArgumentException.class}，会忽略该参数中的异常，不会走兜底方法
    public CommonResult<Payment> handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "fallback,无此流水,exception  " + e.getMessage(), payment);
    }

    // 出现违背sentinel 配置的规则，就会调用这个兜底方法，覆盖默认方法。（降级）
    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }

    //==================使用Feign检查服务提供者是否挂掉(不可用)，如果挂掉了，使用自定义的兜底方法
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}", produces = "application/json;charset=UTF-8")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new RuntimeException("没有该id");
        }
        return paymentService.paymentSQL(id);
    }

}