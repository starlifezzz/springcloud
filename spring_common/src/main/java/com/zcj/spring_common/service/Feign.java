package com.zcj.spring_common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@FeignClient注解通过value指定调用的服务名称，对应application.yml的application-name，如本例为eureka-feign-service-b
//通过fallback指定远程服务调用失败的回调方法，也叫服务降级处理,回调类必须实现使用@FeignClient标识的接口（implements ServiceBFeignClient）
//使用@FeignClient("eureka-feign-service-b")注解来绑定该接口对应feign-service-b服务
@FeignClient(value = "springlogin")
public interface Feign {

    /**
     * 编写Feign接口简便的方法：把具体需要远程调用的服务（如服务B）中的方法复制过来，去掉实现即可。
     *
     * @param name
     * @return
     */
    @GetMapping("/huck")
    String getInfo(@RequestParam("name") String name);

}
