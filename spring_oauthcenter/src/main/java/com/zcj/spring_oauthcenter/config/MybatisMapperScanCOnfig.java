package com.zcj.spring_oauthcenter.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//因为这个对象的扫描，需要在MyBatisConfig的后面注入，所以加上下面的注解
//@AutoConfigureAfter(MybatisConfig.class)
public class MybatisMapperScanCOnfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //这里我特地换成了Mapper 这样你就可以尽量遵循官方的规范 使用mapper注解标识你的Mapper类，同时还可以避免其他的非Mapper接口被无差别扫描
//        mapperScannerConfigurer.setAnnotationClass(org.apache.ibatis.annotations.Mapper.class);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.zcj.spring_oauthcenter");
        return mapperScannerConfigurer;
    }
}
