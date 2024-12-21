package com.jproject.weeService.config;

import com.jproject.weeService.filter.LoginFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfig {

    //Filter : HTTP(S) -> WAS -> Filter -> Servlet -> Controller 이하
    @Bean
    public FilterRegistrationBean<Filter> loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }

    //Interceptor : HTTP(S) -> WAS -> Servlet -> Interceptor -> Controller 이하



}
