package com.whut.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    该Servlet不会被拦截器拦截
    1.Tomcat-Servlet(不经过Spring拦截器) ---> /myServlet
    2.Spring-DispatchServlet(经过Spring拦截器) ---> /
    多个Servlet都能处理同一请求路径时，精确优先原则
 */
@WebServlet(urlPatterns = "/myServlet") // 该注解能够定义该servlet的请求路径
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("springboot servlet 1");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
