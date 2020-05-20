package com.monkey.bootcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: controller控制层
 * @author: monkey.G
 * @create: 2020-05-20 13:14
 **/
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface OrderHelper {

  @RequestMapping("/payment/lb")
  public String getPaymentLB();
}
