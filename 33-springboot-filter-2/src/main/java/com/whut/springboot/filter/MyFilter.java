package com.whut.springboot.filter;

import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
