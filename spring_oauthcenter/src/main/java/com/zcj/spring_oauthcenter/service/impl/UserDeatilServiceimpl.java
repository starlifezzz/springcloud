package com.zcj.spring_oauthcenter.service.impl;

import com.zcj.spring_oauthcenter.dao.TbPermissionDao;
import com.zcj.spring_oauthcenter.dao.TbUserDao;
import com.zcj.spring_oauthcenter.po.TbUser;
import com.zcj.spring_oauthcenter.po.TbUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserDeatilServiceimpl implements UserDetailsService {

    private final TbUserDao tbUserDao;

    private final TbPermissionDao tbPermissionDao;


    @Autowired
    public UserDeatilServiceimpl(TbUserDao tbUserDao, TbPermissionDao tbPermissionDao) {
        this.tbUserDao = tbUserDao;
        this.tbPermissionDao = tbPermissionDao;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUserExample tbUserExample = new TbUserExample();
        tbUserExample.or().andUsernameLike(s);
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<TbUser> tbUsers = tbUserDao.selectByExample(tbUserExample);
        List<Map> maps = tbPermissionDao.queryByUserid(tbUsers.get(0).getId());
        maps.forEach(kk -> {
            System.out.println(kk);
            authorities.add(new SimpleGrantedAuthority(kk.get("ename").toString()));
        });
        return new User(tbUsers.get(0).getUsername(), tbUsers.get(0).getPassword(), authorities);
    }
}
