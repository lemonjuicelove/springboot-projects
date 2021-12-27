package com.whut.springboot.config;

import com.whut.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 该注解将此类定义为配置类（相当于一个xml配置文件）
public class ServletConfig {

    /*
        @Bean：是一个方法级别上的注解，主要用于在配置类里
        相当于<beans>
                <bean id="" class="">
             </beans>
     */
    @Bean
    public ServletRegistrationBean myServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return servletRegistrationBean;
    }

}
