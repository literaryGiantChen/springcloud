package com.diu.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DIU
 * @date 2021/10/14 17:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    Long id;

    /**
     * 产品id
     */
    Long productId;

    /**
     * 总库存
     */
    int total;

    /**
     * 已用库存
     * count + used
     */
    int used;

    /**
     * 剩余库存
     * residue - count
     */
    int residue;

}
