package com.example.springboot01.controller;

import com.example.springboot01.pojo.Motor;
import com.example.springboot01.service.MotorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MotorController {

    private MotorService motorService;

    public MotorController(MotorService motorService) {
        this.motorService = motorService;
    }


    @GetMapping("/getAllMotors")
    public List<Motor> GetAllMotors(){
        //System.out.println("run getAllMotors");
        return  motorService.GETAllMotor();
    }

    @GetMapping("/GetPosition")
    public List<Map> GetPosition(){
        //System.out.println("run GetPosition");
        return motorService.GetPosition();
    }

    @GetMapping("/GetTorque")
    public List<Map> GetTorque(){
        //System.out.println("run GetTorque");
        return motorService.GetTorque();
    }

    @GetMapping("/GetVelocity")
    public List<Map> GetVelocity(){
        //System.out.println("run GetVelocity");
        return motorService.GetVelocity();
    }



}
