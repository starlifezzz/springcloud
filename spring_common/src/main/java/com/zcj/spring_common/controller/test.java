package com.zcj.spring_common.controller;

import com.zcj.spring_common.service.Feign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class test {


    @Resource
    private Feign feign;

    @RequestMapping("/huck")
    String getInfo(@RequestParam("name") String name) {
        return feign.getInfo(name);
    }




}
