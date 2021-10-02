package com.diu.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 444
 * 400 业务错误
 * 999 tomcat超时错误
 * 777 网络错误
 *
 * @Author: DIU
 * @Date: 2021/9/29 9:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }

}
