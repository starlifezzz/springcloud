//package com.zcj.spring_oauthcenter.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
//@Configuration
//@EnableResourceServer
//public class ResourceConfig extends ResourceServerConfigurerAdapter {
//
//
//    /**
//     * 配置资源服务器
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/").hasAuthority("SystemContent")
//                .antMatchers("/view/**").hasAuthority("SystemContentView")
//                .antMatchers("/insert/**").hasAuthority("SystemContentInsert");
//        // 验证所有请求
////                .authorizeRequests()
////                .anyRequest()
////                .authenticated()
//
//    }
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
////        super.configure(resources);
//        resources.resourceId("resource");
//    }
//}
