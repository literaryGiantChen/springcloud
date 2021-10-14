package com.diu.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DIU
 * @date 2021/10/14 17:12
 */
@Configuration
@MapperScan({"com.diu.cloud.dao"})
public class MyBatisConfig {

}
