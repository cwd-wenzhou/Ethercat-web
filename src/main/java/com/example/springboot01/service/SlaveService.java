package com.example.springboot01.service;

import com.example.springboot01.pojo.SlaveInfo;

import java.util.List;

public interface SlaveService {
    List<SlaveInfo> GetAllSlaves();
    SlaveInfo GetSlaveInfobyVenderid(String venderID);
    SlaveInfo GetSlaveInfobyName(String name);
    void InsertSlave(SlaveInfo slaveInfo);
    void deleteSlavebyVenderID(String venderID);
}
