package com.monkey.bootcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @description:
 * @author: monkey.G
 * @create: 2020-05-12 23:28
 **/
@SpringBootApplication
@EnableCircuitBreaker
public class PaymentMain8001 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8001.class,args);
  }

}
