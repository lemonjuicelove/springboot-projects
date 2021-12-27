package com.whut.springboot.controller;

import com.whut.springboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController // 相当于控制层类上加@Controller + 方法上加@ResponseBody
                // 意味着当前控制层中所有的方法返回值都是JSON对象
public class StudentController {

    @RequestMapping("/student")
    public Object student(){
        Student student = new Student();
        student.setId(1);
        student.setName("zhangsan");
        return student;
    }

    // @RequestMapping(value = "/studentDetail",method = RequestMethod.GET)
    @GetMapping("/studentDetail") // 该注解通常在查询数据的时候使用
    public Object studentDetail(){
        return "Only Get Method";
    }

    // @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @PostMapping("/insert") // 该注解通常在新增数据的时候使用
    public Object insert(){
        return "Only Post";
    }

    // @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @DeleteMapping("/delete") // 该注解通常在删除数据的时候使用
    public Object delete(){
        return "Only delete";
    }

    // @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @PutMapping("/update") // 该注解通常在修改数据的时候使用
    public Object update(){
        return "Only put";
    }

}
