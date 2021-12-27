package com.whut.springboot.controller;

import com.whut.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j // 打印日志注解
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/student/count")
    @ResponseBody
    public String studentCount(){

        log.info("查询学生人数");

        Integer studentCount = studentService.queryStudentCount();

        return "学生人数：" + studentCount;
    }

}
