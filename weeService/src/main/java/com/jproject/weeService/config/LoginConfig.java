package com.jproject.weeService.config;

import com.jproject.weeService.filter.LoginFilter;
import com.jproject.weeService.interceptor.LoginInterceptor;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    //Filter : HTTP(S) -> WAS -> Filter -> Servlet -> Controller 이하
//    @Bean
//    public FilterRegistrationBean<Filter> loginFilter() {
//        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new LoginFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setOrder(1);
//
//        return filterRegistrationBean;
//    }

    //Interceptor : HTTP(S) -> WAS -> Servlet -> Interceptor -> Controller 이하
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/wee/main", "/error", "/error/**");
    }

}
