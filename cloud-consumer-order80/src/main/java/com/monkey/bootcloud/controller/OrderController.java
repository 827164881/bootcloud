package com.monkey.bootcloud.controller;

import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 订单类，通过restTemplete调用接口
 * @author: monkey.G
 * @create: 2020-05-13 11:23
 **/
@RestController
@Slf4j
public class OrderController {
//  public static final String PAYMENY_URL = "http://localhost:8001";
  public static final String REMOTE_SERVICE_NAME = "http://CLOUD-PAYMENT-SERVICE/";
  @Autowired
  private RestTemplate restTemplate;

  @PostMapping("/consumer/payment/create")
  public HttpResult<Payment> create(Payment payment) {
    return restTemplate.postForObject(REMOTE_SERVICE_NAME + "payment/create", payment, HttpResult.class);
  }
  @GetMapping("/consumer/payment/get/{id}")
  public HttpResult<Payment> getPayment(@PathVariable("id") Integer id) {
    log.info("ceshi 热部署是否好使222");
    return restTemplate.getForObject(REMOTE_SERVICE_NAME + "payment/"+id, HttpResult.class);
  }

}
