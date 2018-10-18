package com.xiao.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sunjinwei on 2018/1/31.
 *
 * @author sunjinwei
 *         <p>
 *         初始化拦截器配置
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(getWebInterceptor());

        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径
        ir.excludePathPatterns("/**.html", "/**.js", "/**.css", "/configuration/**", "/swagger**", "/v2/**", "/index.jsp", "/fetchR2mCurrentEnv*");

        // 还可以在这里注册其它的拦截器
        //registry.addInterceptor(new OtherInterceptor()).addPathPatterns("/**");
    }


    @Bean
    public HandlerInterceptor getWebInterceptor() {
        return new LoginInterceptor();
    }
}
