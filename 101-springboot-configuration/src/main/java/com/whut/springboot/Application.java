package com.whut.springboot;

import com.whut.springboot.bean.User;
import com.whut.springboot.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan("com.whut.springboot")

@SpringBootApplication // 一个注解相当于上面三个注解
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        // 从容器中获取组件
        User user01 = (User) run.getBean("user01");
        User user02 = run.getBean("user02",User.class);
        User user03 = run.getBean("com.whut.springboot.bean.User", User.class);

        System.out.println(user01);
        System.out.println(user02);
        System.out.println(user03);

        // UserConfig config = run.getBean(UserConfig.class);
        // // 外部调用获取对象
        // User user11 = config.user01();
        // User user22 = config.user01();
        // System.out.println(user11 == user22);

    }

}
