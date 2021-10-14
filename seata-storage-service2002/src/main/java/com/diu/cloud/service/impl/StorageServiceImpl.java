package com.diu.cloud.service.impl;

import com.diu.cloud.dao.StorageDao;
import com.diu.cloud.pojo.CommonResult;
import com.diu.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author DIU
 * @date 2021/10/14 17:53
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    StorageDao storageDao;

    @Override
    public CommonResult<String> updateProduct(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        int i = storageDao.updateProduct(productId, count);
        LOGGER.info("------->storage-service中扣减库存结束");
        if (i > 0) {
            return new CommonResult<>(200, "修改产品数量成功");
        } else {
            return new CommonResult<>(400, "修改产品数量失败");
        }
    }

}
