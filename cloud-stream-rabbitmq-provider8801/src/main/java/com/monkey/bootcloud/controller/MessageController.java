package com.monkey.bootcloud.controller;

import com.monkey.bootcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private IMessageProvider iMessageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
       return iMessageProvider.send();
    }
}
