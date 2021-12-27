package com.whut.springboot.controller;

import com.whut.springboot.config.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private School school;

    @RequestMapping("/say")
    @ResponseBody
    public String say(){
        return "学校名称="+school.getName();
    }

}
