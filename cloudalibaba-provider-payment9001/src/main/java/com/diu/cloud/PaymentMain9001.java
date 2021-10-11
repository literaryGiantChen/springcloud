package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DIU
 * @date 2021/10/11 10:28
 * 服务生产者(提供者)
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class PaymentMain9001 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain9001.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
