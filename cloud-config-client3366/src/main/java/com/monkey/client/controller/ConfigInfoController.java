package com.monkey.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigInfoController {
    @Value("${config.info}")
    public String configInfo;

    @RequestMapping("getConfig")
    public String getConfigInfo(){
        return configInfo;
    }
}
