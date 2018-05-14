package com.s2u2m.javaresearch.spring.requestWorkflow.config;


import com.s2u2m.javaresearch.spring.requestWorkflow.filter.CustomizedFilter;
import com.s2u2m.javaresearch.spring.requestWorkflow.interceptor.CustomizedInterceptor;
import com.s2u2m.javaresearch.spring.requestWorkflow.utils.resolver.HeaderTokenResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * class AppServiceConfig
 *
 * @author xiayy860612
 * @date 2018/5/9
 */
@Configuration
public class AppServiceConfig extends WebMvcConfigurationSupport {

    @Autowired
    private CustomizedInterceptor customizedInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customizedInterceptor).addPathPatterns("/**");
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HeaderTokenResolver());
    }

}
