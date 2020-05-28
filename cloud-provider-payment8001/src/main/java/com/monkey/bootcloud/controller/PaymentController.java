package com.monkey.bootcloud.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.entity.Payment;
import com.monkey.bootcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 支付controller
 * @author: monkey.G
 * @create: 2020-05-13 10:23
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "gobolFallBack")
public class PaymentController {
  @Autowired
  private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @PostMapping("payment/create")
  public HttpResult createPayment(@RequestBody Payment payment){
    log.info(payment.toString());
    return paymentService.insert(payment);
  }

  @GetMapping("payment/{id}")
  public HttpResult createPayment(@PathVariable Long id){
    log.info(id+"哈哈355");
    return paymentService.get(id);
  }

  @RequestMapping("/payment/lb")
  public String getPaymentLB(){
    return serverPort;
  }

  @RequestMapping("success")
  public String success(){
    return "thread name："+Thread.currentThread().getName()+"  ,请求成功o(∩_∩)o 哈哈";
  }

  @RequestMapping("timeOut")
  @HystrixCommand(fallbackMethod = "clientTimeOut",commandProperties={
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
  })
  public String timeOut(){
//    ThreadUtil.sleep(5, TimeUnit.SECONDS);
    int i = 10 / 0;
    return "thread name："+Thread.currentThread().getName()+"  ,请求超时o(︶︿︶)o 唉";
  }

  @RequestMapping("paymentCircuitBreaker/{id}")
  String paymentCircuitBreaker(@PathVariable(value = "id") Integer id){
    return paymentService.paymentCircuitBreaker(id);
  }
  @RequestMapping("timeOutDefault")
  @HystrixCommand
  public String timeOutDefault(){
//    ThreadUtil.sleep(5, TimeUnit.SECONDS);
    int i = 10 / 0;
    return "thread name："+Thread.currentThread().getName()+"  ,请求超时o(︶︿︶)o 唉";
  }



  public String clientTimeOut(){
    return "thread name："+Thread.currentThread().getName()+"  ,8001服务降级了";
  }
  public String gobolFallBack(){
    return "thread name："+Thread.currentThread().getName()+"  ,8001服务globol降级了";
  }
}
