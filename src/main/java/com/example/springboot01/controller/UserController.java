package com.example.springboot01.controller;

import com.example.springboot01.pojo.User;
import com.example.springboot01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping({"/signin","/signin.html"})
    public String signin(){
        return "signin";
    }

    @PostMapping("/signin")
    public String signinUser(User user){
        System.out.println(user);
        System.out.println(userService.GetPswbyName(user.getName()));
        System.out.println(user.getPassword());
        if (userService.GetPswbyName(user.getName()).equals(user.getPassword()))
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
        userService.InsertUser(user);
        return "index";
    }
}
