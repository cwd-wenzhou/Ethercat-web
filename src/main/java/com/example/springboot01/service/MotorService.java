package com.example.springboot01.service;

import com.example.springboot01.pojo.Motor;

import java.util.List;
import java.util.Map;

public interface MotorService {
    List<Motor> GETAllMotor();
    List<Map> GetPosition();
    List<Map> GetTorque();
    List<Map> GetVelocity();
    Motor GetMotorByIndex(int index);
    void InsertMotor(Motor motor1);
    void DeleteMotorByIndex(int index);
}
