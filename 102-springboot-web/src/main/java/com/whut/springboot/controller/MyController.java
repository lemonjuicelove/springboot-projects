package com.whut.springboot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PathVariable： 获取路径中的变量
 * @RequestParam： 获取请求的参数
 * @RequestHeader： 获取请求头
 * @CookieValue： 获取cookie值
 * @RequestBody： 获取请求体(post请求)，使用json传数据，把json数据封装到对应对象当中
 * @RequestAttribute： 获取request域的属性
 * @MatrixVariable： 矩阵变量
 *      /cars/sell;name=jack;age=1,2,3      ;后面的都是矩阵变量
 *      cookie禁用了，session的内容怎么使用
 *      url重写：/abc;jsessionid=xxx 把cookie的值使用矩阵变量的方式进行传递
 *
 */
@RestController
public class MyController {

    /*
    请求进来，先找Controller处理，Controller不能处理的在找静态资源处理器
     */
    @RequestMapping("/xu.jpg")
    public String hello(){
        return "hellow";
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map getCar(@PathVariable Map<String,String> pv, // 能够动态的提取参数key和value，并且进行封装
                      @RequestHeader("User-Agent") String userAgent){

        Map<String,Object> map = new HashMap<>();
        map.put("pv",pv);

        return map;
    }

    // 1、语法：/cars/sell;name=jack;age=1,2,3
    // 2、SpringBoot默认禁用了矩阵变量的功能，必须要手动开启
    // 3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carSell(@MatrixVariable("name") String name,
                       @MatrixVariable("age") List<Integer> age){

        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("age",age);
        return map;
    }

    // /boss/1;age=10/2;age=20
    // pathVar属性：找指定url路径的矩阵变量
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer age1,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer age2){

        Map<String,Object> map = new HashMap<>();
        map.put("name",age1);
        map.put("age",age2);
        return map;
    }


}
