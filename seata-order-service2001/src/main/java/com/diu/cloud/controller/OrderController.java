package com.diu.cloud.controller;

import com.diu.cloud.domain.Order;
import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author DIU
 * @date 2021/10/14 16:59
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    public OrderService orderService;

    /**
     * 创建订单
     * http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
     */
    @GetMapping("/order/create")
    public CommonResult<String> create(Order order) {
        orderService.createOrder(order);
        return new CommonResult<>(200, "订单创建成功!");
    }


}
