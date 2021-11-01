package com.example.springboot01.service.impl;

import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.pojo.Motor;
import com.example.springboot01.service.MotorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MotorServiceImpl implements MotorService {
    private final MotorMapper motorMapper;

    public MotorServiceImpl(MotorMapper motorMapper) {
        this.motorMapper = motorMapper;
    }

    @Override
    public List<Motor> GETAllMotor() {
        return motorMapper.GETAllMotor();
    }

    @Override
    public List<Map> GetPosition() {
        return motorMapper.GetPosition();
    }

    @Override
    public List<Map> GetTorque() {
        return motorMapper.GetTorque();
    }

    @Override
    public List<Map> GetVelocity() {
        return motorMapper.GetVelocity();
    }

    @Override
    public Motor GetMotorByIndex(int index) {
        return motorMapper.GetMotorByIndex(index);
    }

    @Override
    public void InsertMotor(Motor motor1) {
        motorMapper.InsertMotor(motor1);
    }

    @Override
    public void DeleteMotorByIndex(int index) {
        motorMapper.DeleteMotorByIndex(index);
    }
}
