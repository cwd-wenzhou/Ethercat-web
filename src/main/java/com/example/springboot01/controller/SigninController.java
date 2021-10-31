package com.example.springboot01.controller;

import com.example.springboot01.dao.UserMapper;
import com.example.springboot01.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SigninController {
    private final UserMapper userMapper;

    public SigninController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping({"/signin","/signin.html"})
    public String signin(){
        return "signin";
    }

    @PostMapping("/signin")
    public String signinUser(User user){
        System.out.println(user);
        System.out.println(userMapper.GetPswbyName(user.getName()));
        System.out.println(user.getPassword());
        if (userMapper.GetPswbyName(user.getName()).equals(user.getPassword()))
            return "redirect:/index";
        else
            return "signin";
    }

    @GetMapping({"/signup","/signup.html"})
    public String signup(){
        return "signup";
    }

    @PostMapping({"/signup","/signup.html"})
    public String signupUser(User user){
        userMapper.InsertUser(user);
        return "index";
    }
}
