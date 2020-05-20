package com.monkey.bootcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

public interface IRibbonRole {

  ServiceInstance instances(List<ServiceInstance> serviceInstance);

}
