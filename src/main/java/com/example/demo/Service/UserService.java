package com.example.demo.Service;

import com.example.demo.Mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo userPassMatching(String userName){
        UserInfo userInfo =userInfoMapper.userPassMatching(userName);
        return  userInfo;
    }



}
