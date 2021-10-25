package com.example.springboot01.controller;

import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.pojo.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MotorController {

    @Autowired
    private MotorMapper motorMapper;

    @GetMapping("/getAllMotors")
    public List<Motor> GetAllMotors(){
        return  motorMapper.GETAllMotor();
    }
}
