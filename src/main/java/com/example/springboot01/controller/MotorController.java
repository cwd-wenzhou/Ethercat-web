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

    @GetMapping("/GetPosition/{position}/{timeval}")
    public List<Map> GetPosition(@PathVariable("position") String pos,@PathVariable("timeval") long timeval){
        //System.out.println("run GetPosition");
        //System.out.println(pos);
        //return motorService.GetPosition(pos);
        //System.out.println(pos+"timeval="+timeval);
        Date date = new Date(System.currentTimeMillis()-timeval);
        return motorService.GetPositionByTime(pos,date,new Date(System.currentTimeMillis()));
    }

    @GetMapping("/GetTorque/{position}/{timeval}")
    public List<Map> GetTorque(@PathVariable("position") String pos,@PathVariable("timeval") long timeval){
        //System.out.println("run GetTorque");
        Date date = new Date(System.currentTimeMillis()-timeval);
        return motorService.GetTorqueByTime(pos,date,new Date(System.currentTimeMillis()));
    }

    @GetMapping("/GetVelocity/{position}/{timeval}")
    public List<Map> GetVelocity(@PathVariable("position") String pos,@PathVariable("timeval") long timeval){
        //System.out.println("run GetVelocity");
        Date date = new Date(System.currentTimeMillis()-timeval);
        return motorService.GetVelocityByTime(pos,date,new Date(System.currentTimeMillis()));
    }



}
