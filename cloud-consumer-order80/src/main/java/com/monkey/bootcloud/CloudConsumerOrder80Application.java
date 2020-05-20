package com.monkey.bootcloud;

import com.monkey.ribbon.MyRibbonRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description: 消费的主启动类
 * @author: monkey.G
 * @create: 2020-05-13 11:20
 **/
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration ={IRibbonRole.class})
public class CloudConsumerOrder80Application {

  public static void main(String[] args) {
    SpringApplication.run(CloudConsumerOrder80Application.class,args);
  }

}
