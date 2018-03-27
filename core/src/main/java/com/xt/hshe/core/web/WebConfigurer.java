package com.xt.hshe.core.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 *
 * @author Shawn Chen
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public AuthInterceptor userInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor());
        super.addInterceptors(registry);
    }
}
