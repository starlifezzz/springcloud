package com.zcj.spring_login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Resouce {


    @Configuration
    public class WebMvcStaticConfig implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("/staticfile/**").addResourceLocations(
//          "file:"+myConstant.getEditorFile()+File.separator);
//    registry.addResourceHandler("/ueditor/**").addResourceLocations(
//          "file:"+myConstant.getUeditorPath()+File.separator+"ueditor"+File.separator);
//    //registry.addResourceHandler("/**").addResourceLocations("classpath:static/resources/");
//

        }
    }
}
