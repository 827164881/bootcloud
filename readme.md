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