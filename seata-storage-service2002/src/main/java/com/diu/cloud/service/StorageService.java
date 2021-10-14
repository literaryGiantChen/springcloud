package com.diu.cloud.service;

import com.diu.cloud.pojo.CommonResult;

/**
 * @author DIU
 * @date 2021/10/14 17:53
 */
public interface StorageService {

    CommonResult<String> updateProduct(Long productId, Integer count);

}
