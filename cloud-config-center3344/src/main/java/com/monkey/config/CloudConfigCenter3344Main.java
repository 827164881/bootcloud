package com.monkey.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter3344Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344Main.class,args);
    }
}
