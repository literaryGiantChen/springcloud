package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DIU
 * @date 2021/9/29 19:59
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class MainApp80 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApp80.class);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }
}
