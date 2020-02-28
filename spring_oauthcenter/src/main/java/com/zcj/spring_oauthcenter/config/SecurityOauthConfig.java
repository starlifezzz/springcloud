package com.zcj.spring_oauthcenter.config;

import com.zcj.spring_oauthcenter.dao.TbPermissionDao;
import com.zcj.spring_oauthcenter.service.impl.UserDeatilServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityOauthConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final UserDeatilServiceimpl userDeatilServiceimpl;

    private final TbPermissionDao tbPermissionDao;

    @Autowired
    public SecurityOauthConfig(PasswordEncoder passwordEncoder, UserDeatilServiceimpl userDeatilServiceimpl, TbPermissionDao tbPermissionDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDeatilServiceimpl = userDeatilServiceimpl;
        this.tbPermissionDao = tbPermissionDao;
    }


    /**
     * 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("admin").and().withUser("user").password(passwordEncoder.encode("admin")).roles("user");
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDeatilServiceimpl);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/oauth/check_token");
    }

}
