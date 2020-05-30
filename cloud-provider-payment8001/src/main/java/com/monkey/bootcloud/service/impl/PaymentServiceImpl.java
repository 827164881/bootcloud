package com.monkey.bootcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.dao.PaymentDao;
import com.monkey.bootcloud.entity.Payment;
import com.monkey.bootcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 支付服务实体类
 * @author: monkey.G
 * @create: 2020-05-13 10:24
 **/
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentDao paymentDao;

  @Override
  public HttpResult insert(Payment payment) {
    int insert = paymentDao.insert(payment);
    if(insert>0){
      return new HttpResult(201,"成功");
    }else {
      return new HttpResult(444,"失败");
    }
  }

  @Override
  public HttpResult get(Long id) {
    Payment payment = paymentDao.queryById(id);
    log.info("这里用来测试的");
    return new HttpResult(200,"成功from"+8001,payment);
  }

  @Override
  @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback", commandProperties = {
          //是否开启断路器
          @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
          //请求次数
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
          //时间窗口期
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
          //失败率达到多少后跳闸
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
  })
  public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
    if(id!=null && id<0){
      throw new RuntimeException("id不能是负数");
    }else{
      String serialNumber = IdUtil.simpleUUID();
      return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
  }

  public String paymentCircuitBreak_fallback(@PathVariable("id") Integer id){
      return "******************************"+id+"********************";
  }
}
