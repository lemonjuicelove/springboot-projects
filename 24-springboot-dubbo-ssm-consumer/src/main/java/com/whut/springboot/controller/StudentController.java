package com.whut.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.whut.springboot.model.Student;
import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Reference(interfaceName = "com.whut.springboot.service.StudentService",version = "1.0.0")
    private StudentService studentService;

    @RequestMapping("/student/detail")
    public ModelAndView studentDetail(Integer id){

        ModelAndView mv = new ModelAndView();

        Student student = studentService.queryStudentById(id);

        mv.addObject("student",student);
        mv.setViewName("studentDetail");

        return mv;
    }

    @RequestMapping("/student/count")
    @ResponseBody
    public Object allCount(){
        Integer allCount = studentService.queryStudentCount();
        return "学生人数：" + allCount;
    }


}
