package com.diu.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 错误访问：http://localhost:9527/payment/lb?username2=12321sad
        // 正确访问：http://localhost:9527/payment/lb?username=12321sad
        log.info("time: {}  执行了自定义的全局过滤器: " + "MyLogGateWayFilter" + "hello", new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");

        if (username == null) {
            log.info("****用户名错误 或者 用户名为null，无法登录");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
