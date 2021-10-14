package com.diu.cloud.dao;

import com.diu.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author DIU
 * @date 2021/10/14 17:01
 */
@Mapper
public interface OrderDao {

    /**
     * 创建订单
     *
     * @param order 订单全部信息
     */
    int createOrder(Order order);

    /**
     * 修改状态码
     *
     * @param userId 订单号
     * @param status 状态码
     * @return
     */
    int updateStatus(@Param("userId") Long userId, @Param("status") Integer status);

}
