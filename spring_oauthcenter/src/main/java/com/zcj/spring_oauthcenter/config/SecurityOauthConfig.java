package com.zcj.spring_oauthcenter.config;

import com.zcj.spring_oauthcenter.service.impl.UserDeatilServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@EnableWebSecurity
public class SecurityOauthConfig extends WebSecurityConfigurerAdapter {


    private final UserDeatilServiceimpl userDeatilServiceimpl;

    private final PasswordEncoder passwordEncoder;

    //    //    自定义过滤器
//    private final MyFilterSecurityInterceptor myFilterSecurityInterceptor;
//
//    @Autowired
//    public SecurityOauthConfig(UserDeatilServiceimpl userDeatilServiceimpl, PasswordEncoder passwordEncoder, MyFilterSecurityInterceptor myFilterSecurityInterceptor) {
//        this.userDeatilServiceimpl = userDeatilServiceimpl;
//        this.passwordEncoder = passwordEncoder;
//        this.myFilterSecurityInterceptor = myFilterSecurityInterceptor;
//    }
    @Autowired
    public SecurityOauthConfig(UserDeatilServiceimpl userDeatilServiceimpl, PasswordEncoder passwordEncoder) {
        this.userDeatilServiceimpl = userDeatilServiceimpl;
        this.passwordEncoder = passwordEncoder;
    }


//    /**
//     * 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
//     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }


    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(Collections.singletonList(provider));
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//  wlogin为登录页面，/login是登录接口，/oauth/**喝/noOauth为不登陆可以访问发接口，/tockentest是登录用户后需要SystemUserView权限才能访问的接口
        http.formLogin().loginPage("/wlogin").permitAll().loginProcessingUrl("/login")
                .and().authorizeRequests().antMatchers("/oauth/**", "/noOauth", "/getuser").permitAll()
                .antMatchers("/tockentest").hasAuthority("SystemUserView")
                .anyRequest().authenticated();
//        http.authorizeRequests().anyRequest().access("@authService.canAccess(request,authentication)");
//                .and().csrf().disable().addFilterBefore(myFilterSecurityInterceptor, RememberMeAuthenticationFilter.class);

//        http.csrf().disable();
//        http.requestMatchers().anyRequest()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/**").permitAll().and().formLogin().loginPage("/login");
//        http.authorizeRequests().antMatchers("/oauth/**").permitAll().antMatchers("/hhhh").hasAnyRole("aaa")
//                .and().csrf().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder.encode("admin")).roles("admin")
//                .and()
//                .withUser("user").password(passwordEncoder.encode("admin")).roles("user");
//    }

    /**
     * 设置验证权限为数据库验证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDeatilServiceimpl);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/oauth/check_token");
    }

}
