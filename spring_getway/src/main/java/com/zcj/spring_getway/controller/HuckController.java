package com.zcj.spring_getway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HuckController {

    @GetMapping("/nnnn")
    public String jjjj(){
        return "fffff";
    }
}
