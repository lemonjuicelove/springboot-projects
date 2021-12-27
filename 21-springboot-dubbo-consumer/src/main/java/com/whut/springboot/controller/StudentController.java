package com.whut.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    // dubbo注解，引用远程接口服务
    @Reference(interfaceClass = StudentService.class,version = "1.0.0")
    private StudentService studentService;

    @RequestMapping("/student/count")
    @ResponseBody
    public Object studentCount(){
        Integer allCount = studentService.queryAllCount();
        return "学生人数为：" + allCount;
    }
}
