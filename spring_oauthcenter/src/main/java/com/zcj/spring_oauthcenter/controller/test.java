package com.zcj.spring_oauthcenter.controller;

import com.zcj.spring_oauthcenter.dao.OauthCodeDao;
import com.zcj.spring_oauthcenter.po.OauthCode;
import com.zcj.spring_oauthcenter.po.OauthCodeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class test {

    private final OauthCodeDao oauthCodeDao;

    @Autowired
    public test(OauthCodeDao oauthCodeDao) {
        this.oauthCodeDao = oauthCodeDao;
    }


    @RequestMapping("/hhhh")
    public List<OauthCode> oauthCode() {
        OauthCodeExample oauthCodeExample = new OauthCodeExample();
        List<OauthCode> oauthCodes = oauthCodeDao.selectByExample(oauthCodeExample);
        return oauthCodes;
    }


    @RequestMapping("/tockentest")
    public String tockentest() {
        return "success";
    }
}
