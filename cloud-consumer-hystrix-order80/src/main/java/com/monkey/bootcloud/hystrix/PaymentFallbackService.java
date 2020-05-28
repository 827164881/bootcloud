package com.monkey.bootcloud.hystrix;

import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @description: paymentService的服务熔断类
 * @author: monkey.G
 * @create: 2020-05-23 00:12
 **/
@Component
public class PaymentFallbackService implements MicroPaymentService{

  @Override
  public HttpResult createPayment(Payment payment) {
    return new HttpResult(444,"失败");
  }

  @Override
  public HttpResult createPayment(Long id) {
    return new HttpResult(555,"失败");
  }

  @Override
  public String getPaymentLB() {
    return "(┬＿┬)";
  }

  @Override
  public String success() {
    return ":-)";
  }

  @Override
  public String timeOut() {
    return "o(︶︿︶)o 唉";
  }

  @Override
  public String timeOutDefault() {
    return "<(‵^′)>";
  }

  @Override
  public String paymentCircuitBreaker(Integer id) {
    return "服务器不能处理您的请求，请稍后";
  }
}
