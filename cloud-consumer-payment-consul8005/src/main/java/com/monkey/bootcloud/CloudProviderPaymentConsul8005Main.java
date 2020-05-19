package com.monkey.bootcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 主启动类
 * @author: monkey.G
 * @create: 2020-05-18 11:44
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPaymentConsul8005Main {

  public static void main(String[] args) {
    SpringApplication.run(CloudProviderPaymentConsul8005Main.class,args);
  }

}
