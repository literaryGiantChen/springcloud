package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class ConfigClientMain3366 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigClientMain3366.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
