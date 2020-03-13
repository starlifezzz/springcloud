package com.zcj.spring_oauthcenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * oauth2资源服务器配置
 */
@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {


    /**
     * 配置url拦截配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests().antMatchers("/oauth/**", "/hhhh","oauth/authorize").permitAll().anyRequest().authenticated()
//                .and().formLogin().and().httpBasic();

        http.requestMatcher(new OAuth2RequestedMatcher()).
                authorizeRequests().
                anyRequest().authenticated();
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/oauth/**","/hhhh").permitAll()
//                .anyRequest().authenticated().and().formLogin().and().httpBasic();
        // 验证所有请求
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()

    }


    /**
     * 判断来源请求是否包含oauth2授权信息
     */
    private static class OAuth2RequestedMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            // 请求参数中包含access_token参数
            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
                return true;
            }

            // 头部的Authorization值以Bearer开头
            String auth = request.getHeader("Authorization");
            if (auth != null) {
                return auth.startsWith(OAuth2AccessToken.BEARER_TYPE);
            }

            return false;
        }
    }

//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
////        super.configure(resources);
//        resources.resourceId("resource");
//    }
}
