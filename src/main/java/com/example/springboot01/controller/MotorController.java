package com.example.springboot01.controller;

import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.pojo.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MotorController {

    @Autowired
    private MotorMapper motorMapper;

    @GetMapping("/getAllMotors")
    public List<Motor> GetAllMotors(){
        System.out.println("run getAllMotors");
        return  motorMapper.GETAllMotor();
    }

    @GetMapping("/GetPosition")
    public List<Map> GetPosition(){
        System.out.println("run GetPosition");
        return motorMapper.GetPosition();
    }

    @GetMapping("/GetTorque")
    public List<Map> GetTorque(){
        System.out.println("run GetTorque");
        return motorMapper.GetTorque();
    }

    @GetMapping("/GetVelocity")
    public List<Map> GetVelocity(){
        System.out.println("run GetVelocity");
        return motorMapper.GetVelocity();
    }



}
