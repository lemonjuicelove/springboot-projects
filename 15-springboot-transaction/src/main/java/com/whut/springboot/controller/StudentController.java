package com.whut.springboot.controller;

import com.whut.springboot.model.Student;
import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/update")
    @ResponseBody
    public Object update(Integer id,String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        int count = studentService.updateStudentById(student);
        return "修改结果为：" + count;
    }

}
