package com.zcj.spring_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//eureka客户端
@EnableEurekaClient
//可以被注册中心扫描到
@EnableDiscoveryClient
@SpringBootApplication
public class SpringLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoginApplication.class, args);
	}

}
