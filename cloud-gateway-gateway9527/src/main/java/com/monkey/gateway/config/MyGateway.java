package com.monkey.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyGateway {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("国内", r -> r.path("/news").uri("https://www.oschina.net/news"))
                .route("shipin", r -> r.path("/71").uri("https://www.bilibili.com/video/BV1rE411x7Hz?p=71"))
                .build();
    }
}
