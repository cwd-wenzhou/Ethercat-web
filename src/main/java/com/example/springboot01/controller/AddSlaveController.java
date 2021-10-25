package com.example.springboot01.controller;

import com.example.springboot01.pojo.SlaveInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddSlaveController {
    @GetMapping ({"/addslave","/addslave.html"})
    public String addslave(){
        return "addslave";
    }

    @PostMapping ({"/addslave","/addslave.html"})
    public String addslaveimpl(SlaveInfo slaveInfo){
        //model.getAttribute("")
        System.out.println(slaveInfo);
        System.out.println("run here");
        return "redirect:/index";
    }
}