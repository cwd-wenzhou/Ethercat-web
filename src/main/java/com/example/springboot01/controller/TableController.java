package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {
    @RequestMapping({"/tables.html","/tables"})
    public String signup(){
        return "tables";
    }
}
