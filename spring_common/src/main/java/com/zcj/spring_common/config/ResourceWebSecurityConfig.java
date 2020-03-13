package com.zcj.spring_common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * 配置验证tocken的方式相当于
 * 这里的配置相当于properties里面的配置
 */
@Configuration
@EnableWebSecurity
public class ResourceWebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 这里的配置相当于properties里面的配置
     * security.oauth2.client.client-id=dev
     * security.oauth2.client.client-secret=dev
     * security.oauth2.resource.id=resource
     * security.oauth2.resource.token-info-uri=http://localhost:8089/oauth/check_token
     *
     * @return
     */
    @Bean
    public ResourceServerTokenServices resourceServerTokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        //在认证服务器配置的，订单服务的clientId
        tokenServices.setClientId("dev");

        //在认证服务器配置的，订单服务的ClientSecret
        tokenServices.setClientSecret("dev");

        //认证服务器的url
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8087/springoauthcenter/oauth/check_token");//
        return tokenServices;
    }

    /**
     * 要认证跟用户相关的信息，一般用 AuthenticationManager
     * 覆盖这个方法，可以将AuthenticationManager暴露为一个Bean
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
        authenticationManager.setTokenServices(resourceServerTokenServices());//设置为自定义的TokenServices，去校验令牌
        return authenticationManager;
    }


}

