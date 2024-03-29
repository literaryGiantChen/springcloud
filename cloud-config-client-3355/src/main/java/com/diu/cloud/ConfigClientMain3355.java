package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DIU
 * @date 2021/10/10 20:55
 */
@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class ConfigClientMain3355 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigClientMain3355.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
