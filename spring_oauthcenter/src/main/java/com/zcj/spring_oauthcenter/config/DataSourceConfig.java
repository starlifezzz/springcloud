package com.zcj.spring_oauthcenter.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;


@Configuration
public class DataSourceConfig {

    @Bean
    public DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriver(new Driver());
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/oauth?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=true");
        return druidDataSource;
    }
}
