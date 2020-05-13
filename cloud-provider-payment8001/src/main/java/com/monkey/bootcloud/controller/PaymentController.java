package com.monkey.bootcloud.controller;

import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.entity.Payment;
import com.monkey.bootcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 支付controller
 * @author: monkey.G
 * @create: 2020-05-13 10:23
 **/
@RestController
@Slf4j
public class PaymentController {
  @Autowired
  private PaymentService paymentService;

  @PostMapping("payment/create")
  public HttpResult createPayment(@RequestBody Payment payment){
    log.info(payment.toString());
    return paymentService.insert(payment);
  }

  @GetMapping("payment/{id}")
  public HttpResult createPayment(@PathVariable Long id){
    log.info(id+"哈哈3");
    return paymentService.get(id);
  }

}
