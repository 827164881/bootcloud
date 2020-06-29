package com.monkey.bootcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class IMessageListener {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者2："+ message.getPayload()+"\t端口："+port);
    }
}
