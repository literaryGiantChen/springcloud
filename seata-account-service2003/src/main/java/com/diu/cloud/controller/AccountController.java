package com.diu.cloud.controller;

import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author DIU
 * @date 2021/10/14 19:15
 */
@RestController
@Slf4j
public class AccountController {

    public AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/account/decrease", produces = "application/json; charset=UTF-8")
    public CommonResult<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        return accountService.updateMoney(userId, money);
    }

}
