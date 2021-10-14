package com.diu.cloud.service;

import com.diu.cloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author DIU
 * @date 2021/10/14 17:16
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 扣减账户余额
     *
     * @param userId 用户编号
     * @param money  本次订单消费金额
     * @return
     */
    @PostMapping(value = "/account/decrease", produces = "application/json; charset=UTF-8")
    CommonResult<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
