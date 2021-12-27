package com.whut.springboot.controller;

import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/put")
    @ResponseBody
    public Object put(String key,String value){
        studentService.put(key,value);
        return "值已经放入redis";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        String count = studentService.get("count");
        return "数据为"+count;
    }

}
