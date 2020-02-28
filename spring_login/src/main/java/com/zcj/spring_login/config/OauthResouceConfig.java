//package com.zcj.spring_login.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
//
//@Configuration
//@EnableResourceServer
//public class OauthResouceConfig extends ResourceServerConfigurerAdapter {
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        super.configure(resources);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
//        AuthenticationManager oauthAuthenticationManager = oauthAuthenticationManager(http);
//        //OAuth2核心过滤器
//        OAuth2AuthenticationProcessingFilter resourcesServerFilter = new OAuth2AuthenticationProcessingFilter();
//        resourcesServerFilter.setAuthenticationEntryPoint(authenticationEntryPoint);
//        //OAuth2AuthenticationManager，只有被OAuth2AuthenticationProcessingFilter拦截到的oauth2相关请求才被特殊的身份认证器处理。
//        resourcesServerFilter.setAuthenticationManager(oauthAuthenticationManager);
//        if (eventPublisher != null) {
//            //同上
//            resourcesServerFilter.setAuthenticationEventPublisher(eventPublisher);
//        }
//        if (tokenExtractor != null) {
//            //同上
//            resourcesServerFilter.setTokenExtractor(tokenExtractor);
//        }
//        resourcesServerFilter = postProcess(resourcesServerFilter);
//        resourcesServerFilter.setStateless(stateless);
//
//        if (!Boolean.TRUE.toString().equals(apolloCouponConfig.getOauthEnable())) {
//            // 不需要令牌,直接访问资源
//            http.authorizeRequests().anyRequest().permitAll();
//        } else {
//            http
//                    //.anonymous().disable()  //匿名访问
//                    .antMatcher("/**")        //匹配需要资源认证路径
//                    .authorizeRequests()
//                    .antMatchers("/swagger-ui.html", "/swagger-resources/**",
//                            "/v2/api-docs/**", "/validatorUrl", "/valid"
//                    ).permitAll()            //匹配不需要资源认证路径
//                    .anyRequest().authenticated()
//                    .and()
//                    .addFilterBefore(resourcesServerFilter, AbstractPreAuthenticatedProcessingFilter.class)
//                    .exceptionHandling() //添加filter
//                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler)  //异常处理
//                    .authenticationEntryPoint(authenticationEntryPoint);   //认证异常流程
//        }
//    }
//}
