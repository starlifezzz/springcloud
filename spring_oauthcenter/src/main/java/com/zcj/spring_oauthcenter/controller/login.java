package com.zcj.spring_oauthcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class login {

    @RequestMapping("/wlogin")
    public String userlogin() {
        return "login";
    }


    @GetMapping("/getuser")
    @ResponseBody
    public Principal getUser(Principal principal) {
        return principal;
    }
}
