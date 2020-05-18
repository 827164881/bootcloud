package com.monkey.bootcloud.controller;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: controller
 * @author: monkey.G
 * @create: 2020-05-18 11:59
 **/
@RestController
@Slf4j
public class CloudProviderController {
  @Value("${server.port}")
  private String serverPort;

  @RequestMapping(value = "/payment/zk")
  public String paymentzk(){
    return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
  }

}
