package com.example.springboot01.service.impl;

import com.example.springboot01.dao.SlaveInfoMapper;
import com.example.springboot01.pojo.SlaveInfo;
import com.example.springboot01.service.SlaveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlaveServiceImpl implements SlaveService {
    private final SlaveInfoMapper slaveInfoMapper;

    public SlaveServiceImpl(SlaveInfoMapper slaveInfoMapper) {
        this.slaveInfoMapper = slaveInfoMapper;
    }

    @Override
    public List<SlaveInfo> GetAllSlaves() {
        return slaveInfoMapper.GetAllSlaves();
    }

    @Override
    public SlaveInfo GetSlaveInfobyVenderid(String venderID) {
        return slaveInfoMapper.GetSlaveInfobyVenderid(venderID);
    }

    @Override
    public void InsertSlave(SlaveInfo slaveInfo) {
        slaveInfoMapper.InsertSlave(slaveInfo);
    }

    @Override
    public void deleteSlavebyVenderID(String venderID) {
        slaveInfoMapper.deleteSlavebyVenderID(venderID);
    }
}
