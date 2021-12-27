package com.whut.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);

        // 获取入口SpringBoot类
        SpringApplication springApplication = new SpringApplication(Application.class);

        // 设置它的属性
        springApplication.setBannerMode(Banner.Mode.OFF);

        // 启动
        springApplication.run(args);
    }

}
