package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {
    @RequestMapping({"/signup","/signup.html"})
    public String signup(){
        return "signup";
    }
}
