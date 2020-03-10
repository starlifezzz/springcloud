package com.zcj.spring_login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.servlet.http.HttpServletResponse;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


//    /**
//     * 配置资源服务器
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests().anyRequest().authenticated();
//    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        super.configure(resources);
        resources.resourceId("resource");
    }
}
