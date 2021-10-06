package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 消费者
 *
 * @Author: DIU
 * @Date: 2021/10/4 15:36
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@Slf4j
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrderHystrixMain80.class);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
