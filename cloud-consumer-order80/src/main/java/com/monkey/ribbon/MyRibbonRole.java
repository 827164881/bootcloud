package com.monkey.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 我的负载均衡策略
 * @author: monkey.G
 * @create: 2020-05-19 22:02
 **/
@Configuration
public class MyRibbonRole {

  @Bean
  public IRule getIRule(){
    return new RandomRule();
  }

}
