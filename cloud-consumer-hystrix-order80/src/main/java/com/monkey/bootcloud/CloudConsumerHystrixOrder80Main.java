package com.monkey.bootcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: hystrix消费端的主启动类
 * @author: monkey.G
 * @create: 2020-05-23 00:09
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class CloudConsumerHystrixOrder80Main {

  public static void main(String[] args) {
    SpringApplication.run(CloudConsumerHystrixOrder80Main.class,args);
  }
}
