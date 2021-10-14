package com.diu.cloud.controller;

import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DIU
 * @date 2021/10/14 17:59
 */
@RestController
@Slf4j
public class StorageController {

    public StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping(value = "/storage/decrease", produces = "application/json; charset=UTF-8")
    public CommonResult<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        return storageService.updateProduct(productId, count);
    }

}
