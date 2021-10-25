package com.example.springboot01;

import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.dao.SlaveInfoMapper;
import com.example.springboot01.pojo.Motor;
import com.example.springboot01.pojo.SlaveInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class Springboot01ApplicationTests {


    @Autowired
    private SlaveInfoMapper slaveInfoMapper;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MotorMapper motorMapper;

    @Test
    void contextLoads() {
        //System.out.println(motor1);
        //System.out.println(dataSource.getClass());
        System.out.println(slaveInfoMapper.GetAllSlaves());
        SlaveInfo testslave = new SlaveInfo("CWDTEST", "1234", "2021", 5, "CWD", "LY", "IMC");
        slaveInfoMapper.InsertSlave(testslave);
        //System.out.println(slaveInfoMapper.GetAllSlaves());
        slaveInfoMapper.deleteSlavebyVenderID("1234");



        Motor motor = new Motor(1234, 22, 1, 1, 1, 1, 1, 1);
        motorMapper.InsertMotor(motor);
        System.out.println(motorMapper.GETAllMotor());
        motorMapper.DeleteMotorByIndex(1234);
    }

}
