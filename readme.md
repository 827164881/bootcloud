# 跟着阳哥学习分布式微服务
maven版本 3.5.4  （3.6.3与低版本idea存在兼容问题）
 ## 构建订单支付功能
 order(客户端消费者)---->payment(微服务提供者8001)  
 1. 建module
 2. 改pom
 3. 写yml
 4. 主启动
 5. 业务类
 
 - 通过注册的服务名调用服务时的restTemplete必须加@LoadBalance  
 - 消费端在application.yml中配置eureka时，如果不想把自己的服务注册到注册中心中，可以加register-with-eureka: false，但是必须加fetch-registry: true，否则无法从配置中心拉取服务。  
 - @LoadBalanced默认是轮询
 
 ## 项目cloud-provider-payment8004为注册zookeeper的生产端
 - 先在centos下安装jdk环境
 - 在centos下安装zookeeper环境
 - 启动报zookeeper连接超时，可能是jar冲突  
 ## 单个服务用dashboard监控
 - 配置dashboard后，监控网址为：http://localhost:8001/hystrix.stream
 - 需要被监控的项目引入注入一个bean
 ```java
 @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
```
## bus消息总线刷新
```$xslt
curl -X POST "http://localhost:3344/actuator/bus-refresh"
```

- 定点通知某一个微服务
```aidl
curl -X POST "http://localhost:3344/actuator/bus-refresh/{destination}"
例如：
curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
```
 
 - 解决mq重复消费，为consumer加分组
 ```aidl
spring:
  application:
    name: cloud-stream-consumer
  cloud:
    stream:
      bindings:
        input:
          destination: studyExchange
          content-type: application/json
          binder: defaultRabbit
          group: monkeyG    # 加group可以解决重复消费的问题
```
- 持久化  
如果配置了group,就是持久化了，如果没有配置group,微服务宕机时的数据会丢失