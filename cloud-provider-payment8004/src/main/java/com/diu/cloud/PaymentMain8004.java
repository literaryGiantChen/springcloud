package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * zookeeper 注册中心管理服务
 *
 * @Author: DIU
 * @Date: 2021/9/30 22:21
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8004 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8004.class);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
