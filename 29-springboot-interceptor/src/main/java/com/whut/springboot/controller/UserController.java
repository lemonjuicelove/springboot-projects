package com.whut.springboot.controller;

import com.whut.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpSession session){
        User user = new User(1001,"zhangsan");
        session.setAttribute("user",user);
        return "login success";
    }

    @RequestMapping("/center")
    @ResponseBody
    public Object center(){
        return "see center message";
    }

    @RequestMapping("/out")
    @ResponseBody
    public Object out(){
        return "see out anytime";
    }

    @RequestMapping("/error")
    @ResponseBody
    public Object error(){
        return "error";
    }

}
