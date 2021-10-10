package com.diu.cloud.service.impl;

import com.diu.cloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author DIU
 * @date 2021/10/10 18:35
 * 可以理解为是一个消息的发送管道的定义
 * EnableBinding 指信道channel 和 exchange绑定在一起
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString().replaceAll("-", "");
        this.output.send(MessageBuilder.withPayload(serial).build()); // 创建并发送消息
        log.info("*** serial: {}", serial);
        return serial;

    }
}
