package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartShowcaseController {
    @RequestMapping({"/chart-showcase","/chart-showcase.html"})
    public String signup(){
        return "chart-showcase";
    }
}
