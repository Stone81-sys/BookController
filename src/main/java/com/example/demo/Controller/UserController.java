package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.model.UserInfo;
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
    public boolean UserLogin(String name , String password){
        if(!StringUtils.hasLength(name)&&!StringUtils.hasLength(password)){
//            System.out.println("为空");
            return false;
        }

        UserInfo userInfo=userService.userPassMatching(name);
        if(userInfo==null){
//            System.out.println("没有用户");
            return false;
        }

        if(password.equals(userInfo.getPassword())){
//            System.out.println("密码错误");
            return true;
        }

//        System.out.println("没有原因");
        return false;
    }

}