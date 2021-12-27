package com.whut.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/user/detail")
    @ResponseBody
    public Object userDetail(){
        Map<String,Object> map = new HashMap<>();

        map.put("id",1001);
        map.put("name","lisi");

        return map;
    }

    @RequestMapping("/user/page/detail")
    public ModelAndView userPageDetail(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("id",1001);
        mv.addObject("name","lisi");
        mv.setViewName("userDetail");

        return mv;
    }


}
