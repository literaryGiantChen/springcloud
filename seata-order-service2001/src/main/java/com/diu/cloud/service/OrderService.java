package com.diu.cloud.service;

import com.diu.cloud.domain.Order;

/**
 * @author DIU
 * @date 2021/10/14 17:14
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param order 订单全部信息
     */
    int createOrder(Order order);

}
