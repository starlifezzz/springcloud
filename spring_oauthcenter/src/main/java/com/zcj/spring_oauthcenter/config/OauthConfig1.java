package com.zcj.spring_oauthcenter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class OauthConfig1 extends AuthorizationServerConfigurerAdapter {

//    /**
//     * 核心认证管理器
//     */
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private DruidDataSource druidDataSource;

    /**
     * 令牌储存模式
     *
     * @return
     */
    @Bean
    TokenStore tokenStore() {
        return new JdbcTokenStore(druidDataSource);
    }

    /**
     * 密码验证格式
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    DefaultTokenServices defaultTokenServices() {
//
//    }

    @Bean
    public ClientDetailsService jdbcClientDetailsService() {
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(druidDataSource);
        return jdbcClientDetailsService;
    }

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        super.configure(security);
//    }

    /**
     * 客户端授权模式
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory().withClient("client")
//                .secret(passwordEncoder().encode("secret"))
//                .authorizedGrantTypes("authorization_code").scopes("app").redirectUris("http://127.0.0.1:8088/test");
        String dev = passwordEncoder().encode("dev");
        System.out.println(dev);
        //这里和上面内存模式不一样，数据库模式是吧上面的secret，clientid都放在了数据库表中，所以你要手动在oauth_client_details中配置
        clients.withClientDetails(jdbcClientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore());
//        endpoints.authenticationManager(authenticationManager);
    }
}
