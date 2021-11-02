package com.example.springboot01.service.impl;

import com.example.springboot01.dao.SlaveInfoMapper;
import com.example.springboot01.pojo.SlaveInfo;
import com.example.springboot01.service.SlaveService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig
public class SlaveServiceImpl implements SlaveService {
    private final SlaveInfoMapper slaveInfoMapper;

    public SlaveServiceImpl(SlaveInfoMapper slaveInfoMapper) {
        this.slaveInfoMapper = slaveInfoMapper;
    }

    @Override
    //@Cacheable(value = "#GetAllSlaves")
    public List<SlaveInfo> GetAllSlaves() {

        return slaveInfoMapper.GetAllSlaves();
    }

    @Override
    @Cacheable(value = "#GetSlaveInfobyVenderid")
    public SlaveInfo GetSlaveInfobyVenderid(String venderID) {
        return slaveInfoMapper.GetSlaveInfobyVenderid(venderID);
    }
    @Cacheable(value = "#GetSlaveInfobyName")
    public SlaveInfo GetSlaveInfobyName(String name) {

        return slaveInfoMapper.GetSlaveInfobyName(name);
    }
    @Override
    public void InsertSlave(SlaveInfo slaveInfo) {

        slaveInfoMapper.InsertSlave(slaveInfo);
    }

    @Override
    public void deleteSlavebyVenderID(String venderID) {

        slaveInfoMapper.deleteSlavebyVenderID(venderID);
    }

    @Override
    public Integer NumofSlaves() {
        return slaveInfoMapper.NumofSlaves();
    }
}
