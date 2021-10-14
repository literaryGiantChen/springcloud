package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DIU
 * @date 2021/10/12 17:27
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class MainApp8401 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApp8401.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
