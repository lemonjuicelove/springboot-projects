package com.whut.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 开启spring配置注解
@MapperScan(basePackages = "com.whut.springboot.mapper") // 开启扫描Mapper接口的包以及子目录
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
