package com.whut.springboot;

import com.whut.springboot.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private StudentService studentService;

    public static void main(String[] args) {
        // SpringBoot启动程序，会初始化Spring容器
        SpringApplication.run(Application.class, args);
    }

    // 重写CommandLineRunner中的run方法
    @Override
    public void run(String... args) throws Exception {

        String world = studentService.sayHello("world");
        System.out.println(world);

    }

}
