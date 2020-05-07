package com.zcj.spring_oauthcenter.mapper.fffff.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcj.spring_oauthcenter.mapper.fffff.entity.TbUser;
import com.zcj.spring_oauthcenter.mapper.fffff.mapper.TbUserMapper;
import com.zcj.spring_oauthcenter.mapper.fffff.service.impl.TbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/fffff/tb-role")
public class TbRoleController {

    private final TbUserServiceImpl tbUserService;


    @Autowired
    public TbRoleController(TbUserServiceImpl tbUserService) {
        this.tbUserService = tbUserService;
    }


    @RequestMapping("/ffff")
    public void getHuck() {
        TbUserMapper baseMapper = tbUserService.getBaseMapper();
        Page page = new Page();
        page.setSize(10);
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper();
        queryWrapper.like("id", "1");
//        queryWrapper.in("username", new ArrayList<>());
        List<TbUser> list1 = tbUserService.list(queryWrapper);
        Page page1 = tbUserService.page(page, null);
        List<TbUser> records = page1.getRecords();
        for (TbUser record : records) {
            System.out.println(record);
        }
    }
}
