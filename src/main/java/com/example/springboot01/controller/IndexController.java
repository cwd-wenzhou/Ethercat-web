package com.example.springboot01.controller;

import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.dao.SlaveInfoMapper;
import com.example.springboot01.pojo.Motor;
import com.example.springboot01.pojo.SlaveInfo;
import com.example.springboot01.service.impl.SlaveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private MotorMapper motorMapper;

    @Autowired
    private SlaveServiceImpl slaveService;

    @GetMapping({"/index","/","/#","/index.html"})
    public String index(Model model){
        //List<Motor> allMotors = motorMapper.GETAllMotor();
        List<SlaveInfo> slaveInfos = slaveService.GetAllSlaves();
        //System.out.println(slaveService.GetSlaveInfobyName("Beckhoff_EL4102"));
        //model.addAttribute("allmotor",allMotors);
        model.addAttribute("slaveInfos",slaveInfos);

        return "index";
    }


}
