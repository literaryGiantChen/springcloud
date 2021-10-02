package com.diu.cloud.dao;

import com.diu.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: DIU
 * @Date: 2021/9/30 8:06
 */
@Mapper
public interface PaymentDao {

    /**
     * 增加
     *
     * @param payment
     * @return
     */
    public int creat(Payment payment);

    /**
     * 查询ID对应的数据
     *
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);

    /**
     * 修改ID对应的数据
     *
     * @param payment
     * @return
     */
    public int update(Payment payment);

}
