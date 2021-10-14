package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DIU
 * @date 2021/10/14 16:57
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Slf4j
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.diu.cloud.service")
public class SeataOrderMainApp2001 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SeataOrderMainApp2001.class, args);
    }

}
