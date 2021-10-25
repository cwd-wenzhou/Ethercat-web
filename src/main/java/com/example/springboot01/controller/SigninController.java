package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {
    @RequestMapping({"/signin","/signin.html"})
    public String signup(){
        return "signin";
    }
}
