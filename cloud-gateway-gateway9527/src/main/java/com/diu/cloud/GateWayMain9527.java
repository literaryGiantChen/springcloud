package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: DIU
 * @Date: 2021/10/6 21:38
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class GateWayMain9527 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GateWayMain9527.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
