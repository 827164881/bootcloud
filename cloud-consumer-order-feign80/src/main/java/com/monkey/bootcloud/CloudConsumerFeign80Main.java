package com.monkey.bootcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: 通过feign调用服务
 * @author: monkey.G
 * @create: 2020-05-20 12:34
 **/
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerFeign80Main {

  public static void main(String[] args) {
    SpringApplication.run(CloudConsumerFeign80Main.class, args);
  }
}
