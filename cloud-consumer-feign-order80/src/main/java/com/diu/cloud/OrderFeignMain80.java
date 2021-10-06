package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: DIU
 * @Date: 2021/10/3 18:41
 */
@SpringBootApplication
@Slf4j
@EnableFeignClients
public class OrderFeignMain80 {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrderFeignMain80.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
