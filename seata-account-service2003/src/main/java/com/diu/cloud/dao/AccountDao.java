package com.diu.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author DIU
 * @date 2021/10/14 19:04
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     *
     * @param userId 用户编号
     * @param money  本次订单消费金额
     * @return
     */
    int updateMoney(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
