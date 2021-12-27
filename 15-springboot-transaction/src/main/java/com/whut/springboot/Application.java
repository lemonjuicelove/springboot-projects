package com.whut.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// @EnableTransactionManagement // 开启事务(可选项，加不加没有影响)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
