package com.whut.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/user/detail")
    @ResponseBody
    public Object userDetail(){
        return "user/detail";
    }

    @RequestMapping("/center")
    @ResponseBody
    public Object center(){
        return "center";
    }

}
