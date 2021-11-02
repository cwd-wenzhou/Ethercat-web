package com.example.springboot01.service.impl;

import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.pojo.Motor;
import com.example.springboot01.service.MotorService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "motor")
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
    public List<Map> GetPosition(String pos) {
        //System.out.println(pos);
        return motorMapper.GetPosition(pos);
    }

    @Override
    public List<Map> GetTorque(String pos) {
        return motorMapper.GetTorque(pos);
    }

    @Override
    public List<Map> GetVelocity(String pos) {

        return motorMapper.GetVelocity(pos);
    }

    @Override
    @Cacheable(value = "#motorindex")
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
