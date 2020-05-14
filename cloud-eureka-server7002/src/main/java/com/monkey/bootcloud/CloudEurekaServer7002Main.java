package com.monkey.bootcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: eureka7002主启动类
 * @author: monkey.G
 * @create: 2020-05-14 22:36
 **/
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer7002Main {

  public static void main(String[] args) {
    SpringApplication.run(CloudEurekaServer7002Main.class,args);
  }

}
