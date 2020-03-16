package com.zcj.spring_oauthcenter.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@Configuration
public class MyBatiaPlusConfig {


    private final DruidDataSource druidDataSource;

    @Autowired
    public MyBatiaPlusConfig(DruidDataSource druidDataSource) {
        this.druidDataSource = druidDataSource;
    }

    @Bean(name = "sqlSessionFactoryBean")
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean() {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
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

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

}
