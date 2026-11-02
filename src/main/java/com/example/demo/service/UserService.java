package com.example.demo.service;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo userPassMatching(String userName){
        UserInfo userInfo =userInfoMapper.userPassMatching(userName);
        return  userInfo;
    }



}
