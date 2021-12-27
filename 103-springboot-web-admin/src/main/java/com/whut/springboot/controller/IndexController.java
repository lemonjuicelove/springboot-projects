package com.whut.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(String username,String password){
        // 重定向，解决表单重复提交
        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    public String mainPage(){
        int age = 10 /0;
        return "main";
    }

}
