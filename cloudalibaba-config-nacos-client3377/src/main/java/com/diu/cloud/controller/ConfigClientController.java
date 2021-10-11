package com.diu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DIU
 * @date 2021/10/11 14:26
 * RefreshScope 在控制器类加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能。
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    /**
     * http://localhost:3377/config/info
     *
     * @return 配置中心的属性
     */
    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
