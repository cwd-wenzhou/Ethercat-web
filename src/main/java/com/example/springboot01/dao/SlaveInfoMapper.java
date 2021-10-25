package com.example.springboot01.dao;

import com.example.springboot01.pojo.SlaveInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SlaveInfoMapper {
    List<SlaveInfo> GetAllSlaves();
    SlaveInfo GetSlaveInfobyVenderid(String venderID);
    void InsertSlave(SlaveInfo slaveInfo);
    void deleteSlavebyVenderID(String venderID);

}
