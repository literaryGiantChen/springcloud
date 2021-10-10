package com.diu.cloud.contorller;

import com.diu.cloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl provider;

    @GetMapping(value = "/send_message")
    public String sendMessage() {
        return provider.send();
    }

}
