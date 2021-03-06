package com.example.springboot01;

import com.alibaba.fastjson.parser.ParserConfig;
import com.example.springboot01.dao.MotorMapper;
import com.example.springboot01.dao.SlaveInfoMapper;
import com.example.springboot01.dao.UserMapper;
import com.example.springboot01.pojo.Motor;
import com.example.springboot01.pojo.User;
import com.example.springboot01.service.MotorService;
import com.example.springboot01.service.impl.MotorServiceImpl;
import io.lettuce.core.ScriptOutputType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;

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
    private UserMapper userMapper;

    @Autowired
    private MotorService motorService;

    @Autowired
    @Qualifier("MyRedisTemplate")
    private  RedisTemplate<Object,Object> redisTemplate;

    @Test
    void slaveInfoMapperTest() {

//        System.out.println(dataSource.getClass());
//        System.out.println(slaveInfoMapper.GetAllSlaves());
//        SlaveInfo testslave = new SlaveInfo("CWDTEST", "1234", "2021", 5, "CWD", "LY", "IMC");
//        slaveInfoMapper.InsertSlave(testslave);
//        System.out.println(slaveInfoMapper.GetAllSlaves());
//        slaveInfoMapper.deleteSlavebyVenderID("1234");
//        System.out.println(slaveInfoMapper.NumofSlaves());

    }

    @Test
    void motorMapperTest() {
//        System.out.println(motorMapper.GetPosition());
//
//        System.out.println(userMapper.GetPswbyName("cwd"));
//        Motor motor = new Motor(1234, 22, 1, 1, 1, 1, 1, 1);
//        motorMapper.InsertMotor(motor);
//        System.out.println(motorMapper.GETAllMotor());
//        motorMapper.DeleteMotorByIndex(1234);
//        System.out.println(motorMapper.GetAllTorque("1"));
        Date Startdate = new Date(1633753542000L);
        Date Enddate = new Date(1636963137000L);
        //System.out.println(l);
        Date date = new Date(1637049182000L-60000);
        System.out.println(date);
        System.out.println(motorService.GetPositionByTime("1",date,new Date(1637049182000L)));
    }

    @Test
    void userMapperTest() {
        User user = new User("123456", "ly", "cwdhere");
        //userMapper.InsertUser(user);
        user.setPassword("cwdthere");
        System.out.println(userMapper.UpdatePwd(user));
        System.out.println(userMapper.UpdatePwd(user));
        //System.out.println(userMapper.GetPswbyName("cwd"));
        System.out.println(userMapper.GetPswbyName("vvyhg"));
    }



    @Test
    public void redis() {

        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        Motor motor = new Motor(1234, 22, 1, 1, 1, 1, 1, 1);
        redisTemplate.opsForValue().set("cwd",motor);

        Motor cwd = (Motor) redisTemplate.opsForValue().get("cwd");
        //System.out.println(cwd.getTargetPosition());

        //Motor motor1 = JSON.parseObject(cwd.toString(), Motor.class);
        //System.out.println(motor1);
        //System.out.println(redisTemplate.keys("*"));
        //Set<String> keys = redisTemplate.keys("cwd");
    }

    @Test
    public void Cache(){
        MotorServiceImpl motorService = new MotorServiceImpl(motorMapper);
        System.out.println(motorService.GETAllMotor());
        System.out.println(motorService.GETAllMotor());

    }
}
