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