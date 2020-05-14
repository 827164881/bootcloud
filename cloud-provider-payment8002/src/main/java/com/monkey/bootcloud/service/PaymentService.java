package com.monkey.bootcloud.service;

import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.entity.Payment;

/**
 * @description: 支付服务类
 * @author: monkey.G
 * @create: 2020-05-13 10:24
 **/

public interface PaymentService {

  public HttpResult insert(Payment payment);

  HttpResult get(Long id);
}
