package com.zcj.spring_oauthcenter.controller;

import com.zcj.spring_oauthcenter.dao.OauthCodeDao;
import com.zcj.spring_oauthcenter.dao.TbUserDao;
import com.zcj.spring_oauthcenter.po.OauthCode;
import com.zcj.spring_oauthcenter.po.OauthCodeExample;
import com.zcj.spring_oauthcenter.po.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class test {

    private final OauthCodeDao oauthCodeDao;

    private final TbUserDao huckDao;


    @Autowired
    public test(OauthCodeDao oauthCodeDao, TbUserDao huckDao) {
        this.oauthCodeDao = oauthCodeDao;
        this.huckDao = huckDao;
    }


    @RequestMapping("/getCode")
    public List<OauthCode> oauthCode() {
        OauthCodeExample oauthCodeExample = new OauthCodeExample();
        List<OauthCode> oauthCodes = oauthCodeDao.selectByExample(oauthCodeExample);
        return oauthCodes;
    }


    @RequestMapping("/tockentest")
    public String tockentest() {
        return "success";
    }


    @GetMapping("/noOauth")
    public String noOauth() {
        List<TbUser> tbUsers = huckDao.selectList(null);
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser);
        }
        return "无权限";
    }
}
