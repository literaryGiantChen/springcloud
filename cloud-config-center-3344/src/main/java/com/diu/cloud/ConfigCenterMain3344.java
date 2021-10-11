package com.diu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DIU
 * @date 2021/10/10 20:51
 * 中心化的外部配置，相当于github的小弟，github修改，中心化的配置会立即生效
 * 获取github：域名/分支/文件名
 * 案列：http://localhost:3344/master/config-dev.yml
 */
@SpringBootApplication
@Slf4j
@EnableConfigServer
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        // http://config-3344.com:3344/master/config-dev.yml
        // http://localhost:3344/master/config-dev.yml
        ConfigurableApplicationContext run = SpringApplication.run(ConfigCenterMain3344.class, args);
        log.info("初始化组件一共有：{}", run.getBeanDefinitionCount());
    }

}
