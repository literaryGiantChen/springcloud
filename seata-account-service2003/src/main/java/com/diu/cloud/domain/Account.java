package com.diu.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author DIU
 * @date 2021/10/14 18:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    long id;

    /**
     * 用户编号
     */
    long userId;

    /**
     * 总额度
     */
    BigDecimal total;

    /**
     * 已用余额
     * used + money
     */
    BigDecimal used;

    /**
     * 剩余可用额度
     * residue - money
     */
    BigDecimal residue;

}
