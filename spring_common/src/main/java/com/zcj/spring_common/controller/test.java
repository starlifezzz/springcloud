package com.zcj.spring_common.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.zcj.spring_common.service.Feign;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class test {


    @Resource
    private Feign feign;

    //做rsttemplete的接口调用
    public static void main(String[] args) throws JsonProcessingException {
        String url = "http://10.10.15.70:8087/springlogin/huck";
        RestTemplate restTemplate = new RestTemplate();
        JSONObject postData = new JSONObject();
        postData.put("name", "1");
        String url1 = "http://10.10.15.70:8087/springcommon/huck";
        String url2 = "http://localhost:8088/huck";
        String url4 = "http://www.bfqing.com:9888/usercentertest/sso/login";
        HttpHeaders headers = new HttpHeaders();
        //ContentType区分好被请求接口是什么提交方式，是json还是form
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name", "王二狗");
        map.add("username", "18275260675");
        map.add("password", "1qaz@WSX");
        map.add("pcode", "yr4dx");
        HttpEntity<JSONObject> entity = new HttpEntity<>(postData, headers);


        ResponseEntity<String> exchange = restTemplate.exchange(url4,
                HttpMethod.POST, entity, String.class);
        System.out.println(exchange.getBody());

//        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
//
//        String forObject = restTemplate.getForObject("http://10.10.15.70:8087/springlogin/huck", String.class, postData);
//        System.out.println(forObject);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//        map.add("name", "zcj");
//        HttpEntity<MultiValueMap> entity = new HttpEntity<>(map, headers);
//        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

    }

    @RequestMapping("/huck")
    String getInfo(String name) {
        System.err.println(name);
        return feign.getInfo(name);
    }

    @GetMapping("/dddddd")
    public void jkl() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://baidu.com";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("start", 1);
        jsonObj.put("page", 5);

        HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url,
                HttpMethod.GET, entity, JSONObject.class);
        System.out.println(exchange.getBody());
    }

    @RequestMapping("/test")
    public String test() {
        return "kkkkk";
    }

}
