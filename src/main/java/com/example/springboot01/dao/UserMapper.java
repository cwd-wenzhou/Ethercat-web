package com.example.springboot01.dao;

import com.example.springboot01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User GetUserbyName(String name);
    String GetPswbyName(String name);
    void InsertUser(User user);
    int UpdatePwd(User user);
}
