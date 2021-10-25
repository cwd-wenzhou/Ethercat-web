package com.example.springboot01.dao;

import com.example.springboot01.pojo.Motor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MotorMapper {
    List<Motor> GETAllMotor();
    Motor GetMotorByIndex(int index);
    void InsertMotor(Motor motor1);
    void DeleteMotorByIndex(int index);
}

