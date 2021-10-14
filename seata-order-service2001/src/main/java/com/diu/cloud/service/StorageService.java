package com.diu.cloud.service;

import com.diu.cloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DIU
 * @date 2021/10/14 17:16
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param productId 产品编号
     * @param count     数量
     * @return
     */
    @RequestMapping(value = "/storage/decrease", produces = "application/json; charset=UTF-8")
    CommonResult<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
