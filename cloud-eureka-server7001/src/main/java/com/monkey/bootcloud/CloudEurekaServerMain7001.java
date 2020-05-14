package com.monkey.bootcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: eureka的主启动类
 * @author: monkey.G
 * @create: 2020-05-14 11:03
 **/
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerMain7001 {

  public static void main(String[] args) {
    SpringApplication.run(CloudEurekaServerMain7001.class,args);
  }

}
