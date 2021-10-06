package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: DIU
 * @Date: 2021/10/5 18:13
 */
@SpringBootApplication
@Slf4j
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(HystrixDashboardMain9001.class);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
