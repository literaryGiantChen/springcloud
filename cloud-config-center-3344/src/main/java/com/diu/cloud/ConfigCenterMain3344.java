package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
@EnableConfigServer
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        // http://config-3344.com:3344/master/config-dev.yml
        ConfigurableApplicationContext run = SpringApplication.run(ConfigCenterMain3344.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
