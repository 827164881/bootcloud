package com.monkey.bootcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 订单控制类
 * @author: monkey.G
 * @create: 2020-05-20 13:13
 **/
@RestController
@Slf4j
public class OrderController {

  @Autowired
  private OrderHelper helper;

  @RequestMapping("/payment/lb")
  public String getPaymentLB(){
    return helper.getPaymentLB();
  }

  @RequestMapping("/consumer/success")
  public String success(){
    return helper.success();
  }

  @RequestMapping("/consumer/timeOut")
  @HystrixCommand(fallbackMethod = "timeOutFallBack")
  public String timeOut(){
    return helper.timeOut();
  }

  public String timeOutFallBack(){
    return "(┬＿┬)请求服务器超时了";
  }
}
