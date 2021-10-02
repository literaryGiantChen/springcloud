package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * eureka 注册中心管理服务
 * 服务发现 @EnableDiscoveryClient
 *
 * @Author: DIU
 * @Date: 2021/9/29 8:39
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8001.class);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
