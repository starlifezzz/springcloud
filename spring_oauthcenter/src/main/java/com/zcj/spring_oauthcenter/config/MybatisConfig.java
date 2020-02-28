package com.zcj.spring_oauthcenter.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@Configuration
//@MapperScan(basePackages = "com.zcj.spring_oauthcenter.dao")
public class MybatisConfig {

    private final DruidDataSource druidDataSource;

    @Autowired
    public MybatisConfig(DruidDataSource druidDataSource) {
        this.druidDataSource = druidDataSource;
    }


    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        org.springframework.core.io.Resource mybatisConfigXml = resolver.getResource("classpath:/conf/mybatis.xml");
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/conf/mapper/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.zcj.spring_oauthcenter.po");
        return sqlSessionFactoryBean;

    }


}
