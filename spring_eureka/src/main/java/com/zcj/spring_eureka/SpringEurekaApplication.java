package com.zcj.spring_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//eurka服务端
@EnableEurekaServer
@SpringBootApplication
public class SpringEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaApplication.class, args);
    }
}
