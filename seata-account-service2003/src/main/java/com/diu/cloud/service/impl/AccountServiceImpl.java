package com.diu.cloud.service.impl;

import com.diu.cloud.dao.AccountDao;
import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author DIU
 * @date 2021/10/14 19:09
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    public AccountDao accountDao;

    @Override
    public CommonResult<String> updateMoney(Long userId, BigDecimal money) {
        CommonResult<String> commonResult;
        int i = accountDao.updateMoney(userId, money);
        if (i > 0) {
            commonResult = new CommonResult<>(200, "扣减账户：" + userId + " 余额成功");
        } else {
            commonResult = new CommonResult<>(400, "扣减账户：" + userId + " 余额失败");
        }
        return commonResult;
    }

}
