package com.example.springboot01.controller;

import com.example.springboot01.dao.SlaveInfoMapper;
import com.example.springboot01.pojo.SlaveInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddSlaveController {
    private final SlaveInfoMapper slaveInfoMapper;

    public AddSlaveController(SlaveInfoMapper slaveInfoMapper) {
        this.slaveInfoMapper = slaveInfoMapper;
    }

    @GetMapping ({"/addslave","/addslave.html"})
    public String addslave(){
        return "addslave";
    }

    @PostMapping ({"/addslave","/addslave.html"})
    public String addslaveimpl(SlaveInfo slaveInfo){
        //model.getAttribute("")
        slaveInfoMapper.InsertSlave(slaveInfo);
        System.out.println(slaveInfo);
        //System.out.println("run here");
        return "redirect:/index";
    }
}
