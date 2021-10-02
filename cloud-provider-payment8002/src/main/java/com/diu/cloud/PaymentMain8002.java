package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * eureka 注册中心管理服务
 *
 * @Author: DIU
 * @Date: 2021/9/29 8:39
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class PaymentMain8002 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8002.class);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
