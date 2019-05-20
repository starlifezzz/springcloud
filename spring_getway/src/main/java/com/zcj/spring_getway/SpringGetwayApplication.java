package com.zcj.spring_getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGetwayApplication.class, args);
    }

}
