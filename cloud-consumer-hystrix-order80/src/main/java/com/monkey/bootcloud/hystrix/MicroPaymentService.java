package com.monkey.bootcloud.hystrix;

import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.entity.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
public interface MicroPaymentService {

  @PostMapping("payment/create")
  public HttpResult createPayment(@RequestBody Payment payment);

  @GetMapping("payment/{id}")
  public HttpResult createPayment(@PathVariable(value = "id") Long id);

  @RequestMapping("/payment/lb")
  public String getPaymentLB();

  @RequestMapping("success")
  public String success();

  @RequestMapping("timeOut")
  public String timeOut();

  @RequestMapping("timeOutDefault")
  @HystrixCommand
  public String timeOutDefault();

}
