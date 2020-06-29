package com.monkey.bootcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class IMessageListener {

    @Value("${server.port}")
    String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者接受到消息："+message.getPayload()+"/t"+"消费者："+serverPort);
    }
}
