package com.diu.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.diu.cloud.pojo.CommonResult;

/**
 * @author DIU
 * @date 2021/10/13 10:44
 */
public class CustomerBlockHandler {

    public static CommonResult<String> handleException(BlockException exception) {
        return new CommonResult<String>(2020, "自定义的限流处理信息......CustomerBlockHandler");
    }

}
