package com.monkey.bootcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 通用配置类
 * @author: monkey.G
 * @create: 2020-05-13 11:32
 **/
@Configuration
public class CommonConfig {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return  new RestTemplate();
  }

}
