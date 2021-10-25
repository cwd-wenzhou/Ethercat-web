package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalInfoController {
    @RequestMapping("/personal-info.html")
    public String signup(){
        return "personal-info";
    }
}
