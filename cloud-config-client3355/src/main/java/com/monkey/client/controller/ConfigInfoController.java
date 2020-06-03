package com.monkey.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigInfoController {
    @Value("${config.info}")
    public String configInfo;

    @RequestMapping("getConfig")
    public String getConfigInfo(){
        return configInfo;
    }
}
