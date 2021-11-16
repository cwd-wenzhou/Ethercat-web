package com.example.springboot01.dao;

import com.example.springboot01.pojo.Motor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MotorMapper {
    List<Motor> GETAllMotor();
    List<Map> GetAllPosition(String pos);
    List<Map> GetAllTorque(String pos);
    List<Map> GetAllVelocity(String pos);
    List<Map> GetPositionByTime(String pos, @Param("starttime") Date starttime, @Param("stoptime") Date stoptime);
    List<Map> GetTorqueByTime(String pos, Date starttime,Date stoptime);
    List<Map> GetVelocityByTime(String pos, Date starttime,Date stoptime);
    Motor GetMotorByIndex(int index);
    void InsertMotor(Motor motor1);
    void DeleteMotorByIndex(int index);
}

