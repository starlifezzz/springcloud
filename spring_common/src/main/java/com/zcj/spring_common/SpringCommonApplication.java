package com.zcj.spring_common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//eureka客户端
@EnableEurekaClient
//feign客户端
@EnableFeignClients
//可以被注册中心发现
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCommonApplication.class, args);
    }

}
