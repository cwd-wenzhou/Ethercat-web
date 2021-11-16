package com.example.springboot01.controller;

import com.example.springboot01.pojo.Motor;
import com.example.springboot01.service.MotorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @GetMapping("/GetPosition/{position}")
    public List<Map> GetPosition(@PathVariable("position") String pos){
        //System.out.println("run GetPosition");
        //System.out.println(pos);
        //return motorService.GetPosition(pos);
        Date date = new Date(System.currentTimeMillis()-60000);
        return motorService.GetPositionByTime(pos,date,new Date(System.currentTimeMillis()));
    }

    @GetMapping("/GetTorque/{position}")
    public List<Map> GetTorque(@PathVariable("position") String pos){
        //System.out.println("run GetTorque");
        return motorService.GetTorque(pos);
    }

    @GetMapping("/GetVelocity/{position}")
    public List<Map> GetVelocity(@PathVariable("position") String pos){
        //System.out.println("run GetVelocity");
        return motorService.GetVelocity(pos);
    }



}
