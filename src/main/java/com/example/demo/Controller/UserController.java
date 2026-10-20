package com.example.demo.Controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController{
    @RequestMapping("/login")
    public boolean UserLogin(String name , String password){
        if(!StringUtils.hasLength(name)&&!StringUtils.hasLength(password)){
            return false;
        }
        if("zhao".equals(name)&&"1234".equals(password)){
            return true;
        }
        return false;
    }

}