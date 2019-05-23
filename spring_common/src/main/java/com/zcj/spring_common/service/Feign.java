package com.zcj.spring_common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
