package com.whut.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    // 通过value注解获取配置文件中自定义参数的值并赋值给属性
    @Value("${school.name}")
    private String schoolName;

    @RequestMapping("/say")
    @ResponseBody
    public String say(){
        return "hello" + schoolName;
    }

}
