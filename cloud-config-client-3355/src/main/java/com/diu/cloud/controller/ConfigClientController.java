package com.diu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 背景
 * 当遇到生产环境配置参数需要调整，但又没有配置中心的支持的情况下，只能重启应用以加载新参数，可能会影响业务系统运行，太暴力不优雅；
 *
 * @RefreshScope 注解能帮助我们做局部的参数刷新，但侵入性较强，
 * 需要开发阶段提前预知可能的刷新点，并且该注解底层是依赖于cglib进行代理的，
 * 所以不要掉入cglib的坑，出现刷了也不更新情况；
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}
