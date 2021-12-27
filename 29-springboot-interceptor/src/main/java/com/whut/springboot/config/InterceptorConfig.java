package com.whut.springboot.config;

import com.whut.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration // 该注解表示定义此类为配置文件（相当于mvc中的xml配置文件）
public class InterceptorConfig implements WebMvcConfigurer {


    /**
     * Filter、Interceptor功能相同？
     * 1、Filter是Servlet定义的原生组件，脱离Spring应用也能使用
     * 2、Interceptor是Spring定义的接口，可以使用Spring的自动装配等功能
     */
    @Resource
    UserInterceptor userInterceptor;

    // 该方法相当于 mvc:interceptors 标签
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 要拦截的路径
        String[] addPathPatterns = {
            "/**"
        };

        // 不需要拦截的路径
        String[] excludePathPatterns = {
            "/user/out",
            "/user/error",
            "/user/login",
            "/image/**" // 静态资源放在static下，"/"：就代表了static下面的资源
        };

        // 相当于 mvc:interceptor bean class="" 标签
        // 每次都是new一个新的
        // registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);

        // 从容器中拿
        registry.addInterceptor(userInterceptor).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);

    }

}
