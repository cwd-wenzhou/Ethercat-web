package com.example.springboot01.controller;

import com.example.springboot01.pojo.SlaveInfo;
import com.example.springboot01.service.SlaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SlaveController {
    private final SlaveService slaveService;

    public SlaveController(SlaveService slaveService) {
        this.slaveService = slaveService;
    }

    @GetMapping ({"/addslave","/addslave.html"})
    public String addslave(){
        return "addslave";
    }

    @PostMapping ({"/addslave","/addslave.html"})
    public String addslaveimpl(SlaveInfo slaveInfo){
        //model.getAttribute("")
        slaveService.InsertSlave(slaveInfo);
        System.out.println(slaveInfo);
        //System.out.println("run here");
        return "redirect:/index";
    }
}
