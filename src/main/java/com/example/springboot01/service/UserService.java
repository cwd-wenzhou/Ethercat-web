package com.example.springboot01.service;

import com.example.springboot01.pojo.User;

public interface UserService {
    //暂时service层内容与mapper基本一致
    User GetUserbyName(String name);
    String GetPswbyName(String name);
    void InsertUser(User user);
    int UpdatePwd(User user);
}
