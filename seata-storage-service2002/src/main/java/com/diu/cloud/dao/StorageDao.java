package com.diu.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author DIU
 * @date 2021/10/14 17:49
 */
@Mapper
public interface StorageDao {

    /**
     * 修改库存
     *
     * @param productId 产品编号
     * @param count     产品出货数量
     * @return
     */
    int updateProduct(@Param("productId") Long productId, @Param("count") Integer count);

}
