package com.zcj.spring_oauthcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class login {

    @RequestMapping("/wlogin")
    public String userlogin() {
        return "login";
    }
}
