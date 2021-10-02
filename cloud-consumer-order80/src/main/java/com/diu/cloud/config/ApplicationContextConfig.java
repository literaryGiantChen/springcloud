package com.diu.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: DIU
 * @Date: 2021/9/29 20:01
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 是什么
     * RestTemplate提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
     * <p>
     * 使用restTemplate访问restful接口非常的简单粗暴无脑。
     * (url, requestMap, ResponseBean.class)这三个参数分别代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     *
     * @return 获取RestTemplate对象访问restful接口
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
