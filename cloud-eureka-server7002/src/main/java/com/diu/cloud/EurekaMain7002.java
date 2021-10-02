package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: DIU
 * @Date: 2021/9/30 11:07
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaMain7002 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EurekaMain7002.class);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
