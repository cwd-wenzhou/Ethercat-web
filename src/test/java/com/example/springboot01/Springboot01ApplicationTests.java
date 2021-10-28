package com.example.springboot01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.dao.SlaveInfoMapper;
import com.example.springboot01.pojo.Motor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.util.Set;

@SpringBootTest
class Springboot01ApplicationTests {

    static {
        ParserConfig.getGlobalInstance().addAccept("com.example.springboot01.pojo");
    }

    @Autowired
    private SlaveInfoMapper slaveInfoMapper;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MotorMapper motorMapper;

    @Autowired
    @Qualifier("MyRedisTemplate")
    private  RedisTemplate<Object,Object> redisTemplate;

    @Test
    void contextLoads() {
        //System.out.println(motor1);
        //System.out.println(dataSource.getClass());
//        System.out.println(slaveInfoMapper.GetAllSlaves());
//        SlaveInfo testslave = new SlaveInfo("CWDTEST", "1234", "2021", 5, "CWD", "LY", "IMC");
//        slaveInfoMapper.InsertSlave(testslave);
//        //System.out.println(slaveInfoMapper.GetAllSlaves());
//        slaveInfoMapper.deleteSlavebyVenderID("1234");

        System.out.println(motorMapper.GetPosition());


//        Motor motor = new Motor(1234, 22, 1, 1, 1, 1, 1, 1);
//        motorMapper.InsertMotor(motor);
//        System.out.println(motorMapper.GETAllMotor());
//        motorMapper.DeleteMotorByIndex(1234);
    }



    @Test
    public void redis() {

        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        Motor motor = new Motor(1234, 22, 1, 1, 1, 1, 1, 1);
        redisTemplate.opsForValue().set("cwd",motor);

        Motor cwd = (Motor) redisTemplate.opsForValue().get("cwd");
        System.out.println(cwd.getTargetPosition());

        //Motor motor1 = JSON.parseObject(cwd.toString(), Motor.class);
        //System.out.println(motor1);
        //System.out.println(redisTemplate.keys("*"));
        //Set<String> keys = redisTemplate.keys("cwd");
    }
}
