package com.diu.cloud.service;

import com.diu.cloud.pojo.CommonResult;

import java.math.BigDecimal;

/**
 * @author DIU
 * @date 2021/10/14 19:07
 */
public interface AccountService {

    CommonResult<String> updateMoney(Long userId, BigDecimal money);

}
