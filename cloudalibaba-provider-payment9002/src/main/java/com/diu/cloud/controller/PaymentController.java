package com.diu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DIU
 * @date 2021/10/11 10:32
 */
@RestController
@RefreshScope
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }

    @Value("${config.info}")
    private String configInfo;

    /**
     * http://localhost:9002/config/info
     *
     * @return 配置中心的属性
     */
    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
