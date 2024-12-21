package com.jproject.weeService.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    //허용하는 접근
    private static final String[] permittedList = { "/" , "/wee/main"} ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filterConfig? = " + filterConfig);
        log.info("=== Filter 시작 ====");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("ServletRequest = " + servletRequest.toString());
        log.info("ServletResponse = " + servletResponse.toString());
        log.info("filterChain = " + filterChain.toString());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("=== Filter 종료 ===");
    }

}
