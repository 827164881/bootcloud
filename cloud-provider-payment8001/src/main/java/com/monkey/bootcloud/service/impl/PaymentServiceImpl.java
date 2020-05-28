package com.monkey.bootcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.monkey.bootcloud.common.HttpResult;
import com.monkey.bootcloud.dao.PaymentDao;
import com.monkey.bootcloud.entity.Payment;
import com.monkey.bootcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public String paymentCircuitBreaker(Integer id) {
    if(id!=null && id<0){
      return "id不能是负数";
    }else{
      String serialNumber = IdUtil.simpleUUID();
      return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
  }
}
