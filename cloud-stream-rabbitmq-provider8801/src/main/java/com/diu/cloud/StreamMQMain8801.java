package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DIU
 * @date 2021/10/10 18:36
 * 生产者
 */
@SpringBootApplication
@Slf4j
public class StreamMQMain8801 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StreamMQMain8801.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
