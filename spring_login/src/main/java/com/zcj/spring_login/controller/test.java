package com.zcj.spring_login.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

@RestController
public class test {


    @Value("${username}")
    private String usernaem;

    @GetMapping("/huck")
    public String jlk(@RequestParam("name") String name, HttpServletRequest httpServletRequest) {
        System.out.println("调用了");
        return "success" + usernaem + "   " + httpServletRequest.getSession().getId();
    }

    @GetMapping("/luck")
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

    public void resttemplete() {
        String url = "http://www.baidu.com";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONObject postData = new JSONObject();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<JSONObject> entity = new HttpEntity<>(postData, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String body = exchange.getBody();
        System.out.println(body);
    }


}
