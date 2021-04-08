package com.nowcoder.community.config;

import com.nowcoder.community.Controller.interceptor.AlphaInterceptor;
import com.nowcoder.community.Controller.interceptor.LoginRequiredInterceptor;
import com.nowcoder.community.Controller.interceptor.LoginTicketInceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AlphaInterceptor alphaInterceptor;

    @Autowired
    private LoginTicketInceptor loginTicketInceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(alphaInterceptor)
                .excludePathPatterns("**/*.css", "**/*.js", "**/*.png", "**/*.jpg", "**/*.jpeg")
                .addPathPatterns("/register", "/login");

        registry.addInterceptor(loginTicketInceptor)
                .excludePathPatterns("**/*.css", "**/*.js", "**/*.png", "**/*.jpg", "**/*.jpeg");

        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("**/*.css", "**/*.js", "**/*.png", "**/*.jpg", "**/*.jpeg");

    }
}
