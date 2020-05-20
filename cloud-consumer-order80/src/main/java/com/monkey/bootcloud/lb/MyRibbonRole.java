package com.monkey.bootcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * @description: 我的ribbon规则
 * @author: monkey.G
 * @create: 2020-05-20 10:35
 **/
@Component
public class MyRibbonRole implements IRibbonRole {
  private AtomicInteger atomicInteger = new AtomicInteger(0);

  public final int getAndIncrement(){
    int current;
    int next;
    do {
      current = atomicInteger.get();
      next = current == Integer.MAX_VALUE?0:current+1;
    }while (!atomicInteger.compareAndSet(current,next));
    System.out.println("******第next次请求："+next+"********");
    return next;
  }

  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstance) {
    int index = getAndIncrement()%serviceInstance.size();
    return serviceInstance.get(index);
  }
}
