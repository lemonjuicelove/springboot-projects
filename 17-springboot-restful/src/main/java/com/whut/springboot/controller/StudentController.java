package com.whut.springboot.controller;

import com.whut.springboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @RequestMapping("/student")
    public Object student(Student student){
        return student;
    }

    // RESTful风格中方法的请求方式会按增删改查的请求方式来区分，避免出现请求路径冲突的错误
    // 修改请求路径的顺序也可以区分

    /**
     * @PathVariable: 输入在URL路径部分，例如/blogs/1
     * @RequestParam： 输入在携带的参数部分，例如/blogs?blogId=1
     */
    @DeleteMapping("/student/detail/{id}/{age}")
    public Object student1(@PathVariable("id") Integer id,
                           @PathVariable("age") Integer age){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("age",age);
        return map;
    }

    @DeleteMapping("/student/{id}/detail/{time}")
    public Object student2(@PathVariable("id") Integer id,
                           @PathVariable("time") Integer time){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("time",time);
        return map;
    }

    // 和上面会产生请求路径的冲突
    @GetMapping("/student/detail/{id}/{status}")
    public Object student3(@PathVariable("id") Integer id,
                           @PathVariable("status") Integer status){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("status",status);
        return map;
    }



}
