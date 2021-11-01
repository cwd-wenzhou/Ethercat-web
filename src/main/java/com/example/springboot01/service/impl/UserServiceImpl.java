package com.example.springboot01.service.impl;

import com.example.springboot01.dao.UserMapper;
import com.example.springboot01.pojo.User;
import com.example.springboot01.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    //@Cacheable(key = "#id", unless = "#result==null")
    public User GetUserbyName(String name) {
        return userMapper.GetUserbyName(name);
    }

    @Override
    //@Cacheable(key = "#id", unless = "#result==null")
    public String GetPswbyName(String name) {
        return userMapper.GetPswbyName(name);
    }

    @Override
    public void InsertUser(User user) {
        userMapper.InsertUser(user);
    }

    @Override
    public int UpdatePwd(User user) {
        userMapper.UpdatePwd(user);
        return 0;
    }
}
