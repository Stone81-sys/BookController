package com.example.demo.controller;

import com.example.demo.constants.Constants;
import com.example.demo.service.UserService;
import com.example.demo.model.UserInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@ResponseBody
@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public boolean UserLogin(String name , String password, HttpSession session){
        if(!StringUtils.hasLength(name)&&!StringUtils.hasLength(password)){
            return false;
        }

        UserInfo userInfo=userService.userPassMatching(name);
        if(userInfo==null){
            return false;
        }

        if(password.equals(userInfo.getPassword())){
            userInfo.setPassword("");
            session.setAttribute(Constants.USER_KEY,userInfo);
            return true;
        }

        return false;
    }

}