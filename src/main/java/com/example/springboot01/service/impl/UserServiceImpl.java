package com.example.springboot01.service.impl;

import com.example.springboot01.dao.UserMapper;
import com.example.springboot01.pojo.User;
import com.example.springboot01.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User GetUserbyName(String name) {
        return userMapper.GetUserbyName(name);
    }

    @Override
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
