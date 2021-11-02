package com.example.springboot01.controller;

import com.example.springboot01.pojo.SlaveInfo;
import com.example.springboot01.service.SlaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        //todo 增加数据校验
        if (false)
            return "addslave";

        slaveInfo.setPosition(slaveService.NumofSlaves()+1);
        slaveService.InsertSlave(slaveInfo);

        //System.out.println("run here");
        return "redirect:/index";
    }

    @GetMapping("/SlaveNum")
    @ResponseBody
    public int GetSlaveNum(){
        //System.out.println(slaveService.NumofSlaves());
        return slaveService.NumofSlaves();
    }

    @GetMapping("/GetAllSlaves")
    public List<SlaveInfo> GetAllSlaves(){
        return slaveService.GetAllSlaves();
    }
}
