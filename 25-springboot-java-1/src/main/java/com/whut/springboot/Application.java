package com.whut.springboot;

import com.whut.springboot.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        /**
         * SpringBoot程序启动后，返回值是ConfigurableApplication，也是一个Spring容器
         * 其实相当于原来Spring容器中的启动容器ClasspathXmlApplicationContext
         */

        // 获取SpringBoot容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        // 从spring容器中获取指定bean对象
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        String hello = studentService.sayHello();

        System.out.println(hello);

    }

}
