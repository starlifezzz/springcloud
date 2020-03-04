package com.zcj.spring_oauthcenter.config;

import com.zcj.spring_oauthcenter.service.impl.UserDeatilServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@EnableWebSecurity
public class SecurityOauthConfig extends WebSecurityConfigurerAdapter {


    private final UserDeatilServiceimpl userDeatilServiceimpl;

    private final PasswordEncoder passwordEncoder;

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


        http.formLogin().loginPage("/wlogin").permitAll().loginProcessingUrl("/login")
                .and().authorizeRequests().antMatchers("/oauth/**", "/hhhh").permitAll()
                .antMatchers("/tockentest").hasAuthority("SystemUserView")
                .anyRequest().authenticated()
                .and().csrf().disable();

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDeatilServiceimpl);
    }

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/oauth/check_token");
//    }

}
