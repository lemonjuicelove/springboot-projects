package com.whut.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.whut.springboot.model.Student;
import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @RequestMapping("/student/detail")
    public String studentDetail(Model model){
        Student student = studentService.queryStudentById(1);
        model.addAttribute("student",student);

        return "studentDetail";
    }

}
