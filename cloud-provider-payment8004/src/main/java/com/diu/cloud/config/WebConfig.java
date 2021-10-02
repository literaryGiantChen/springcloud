package com.diu.cloud.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;

/**
 * @Author: DIU
 * @Date: 2021/9/30 22:37
 */
public class WebConfig {

    @Bean
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .connectString("192.168.137.130:2181")
                .sessionTimeoutMs(10000)
                .connectionTimeoutMs(50000)
                .retryPolicy(retryPolicy)
                .build();
        zkClient.start();
        return zkClient;
    }

}
