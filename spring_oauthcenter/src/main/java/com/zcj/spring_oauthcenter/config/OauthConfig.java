//package com.zcj.spring_oauthcenter.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//
//@Configuration
////oauth开启认证服务器
//@EnableAuthorizationServer
//public class OauthConfig extends AuthorizationServerConfigurerAdapter {
//
////    /**
////     * 这个实在security里面配置的bean
////     * 认证管理器,上一篇有涉及到,下面有具体描述
////     */
////    private final AuthenticationManager authenticationManager;
////
////    @Autowired
////    public OauthConfig(AuthenticationManager authenticationManager) {
////        this.authenticationManager = authenticationManager;
////    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
////    /**
////     * 配置令牌端点(Token Endpoint)的安全约束.
////     *
////     * @param security
////     * @throws Exception
////     */
////    @Override
////    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
////        /* 配置token获取合验证时的策略 */
////        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
////    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // 配置oauth2的 client信息
//        // authorizedGrantTypes 有4种，这里只开启2种
//        // secret密码配置从 Spring Security 5.0开始必须以 {bcrypt}+加密后的密码 这种格式填写
//        clients.inMemory()
//                .withClient("client")
//                .secret(bCryptPasswordEncoder().encode("secret"))
//                .authorizedGrantTypes("authorization_code").scopes("app").redirectUris("http://127.0.0.1:8088/test");
//    }
//
////    /**
////     * 配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
////     *
////     * @param endpoints
////     * @throws Exception
////     */
////    @Override
////    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
////        // 配置tokenStore
////        endpoints.authenticationManager(authenticationManager).tokenStore(memoryTokenStore());
////    }
////
////    @Bean
////    public TokenStore memoryTokenStore() {
////        return new InMemoryTokenStore();
////    }
//
//
//}
