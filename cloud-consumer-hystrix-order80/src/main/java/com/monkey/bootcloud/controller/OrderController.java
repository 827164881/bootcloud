package com.monkey.bootcloud.controller;

import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.entity.Payment;
import com.monkey.bootcloud.hystrix.MicroPaymentService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 订单类
 * @author: monkey.G
 * @create: 2020-05-23 00:11
 **/
@RestController
@Slf4j
public class OrderController {
  
  @Resource
  private MicroPaymentService paymentService;


  @PostMapping("payment/create")
  public HttpResult createPayment(Payment payment) {
    return paymentService.createPayment(payment);
  }


  public HttpResult createPayment(Long id) {
    return paymentService.createPayment(id);
  }

@RequestMapping("lb")
  public String getPaymentLB() {
    return paymentService.getPaymentLB();
  }

  @RequestMapping("paymentCircuitBreaker/{id}")
  public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id) {
    return paymentService.paymentCircuitBreaker(id);
  }

  public String success() {
    return ":-)";
  }


  public String timeOut() {
    return "o(︶︿︶)o 唉";
  }


  public String timeOutDefault() {
    return "<(‵^′)>";
  }

}
