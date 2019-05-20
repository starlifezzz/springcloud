package com.zcj.spring_login.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

@RestController
public class test {

    @GetMapping("/huck")
    public String jlk() {
        return "success";
    }

    @GetMapping("yuck")
    public Map jkl() {
        Map kj = new TreeMap();
        kj.put("yuk", "测试成功");
        kj.put("duk", "测试成功");
        kj.put("zuk", "测试成功");
        kj.put("buk", "测试成功");
        kj.put("fuk", "测试成功");
        return kj;

    }

    @GetMapping(value = "yuck", produces = "text/event-stream")
    public @ResponseBody
    String sse(HttpServletRequest httpServletRequest) {
        ServletContext servletContext = httpServletRequest.getServletContext();
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet());
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
        dynamic.setAsyncSupported(true);
        Random kj = new Random();
        return "sse:" + kj.nextInt();

    }


    @RequestMapping(value = "sse/get_data", produces = "text/event-stream;charset=UTF-8")
    public String push() {

        try {
            Thread.sleep(1000);
        //第三方数据源调用
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "data:xdclass 行情" + Math.random() + "\n\n";
    }

}
