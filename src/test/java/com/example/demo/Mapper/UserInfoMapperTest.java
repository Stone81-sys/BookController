package com.example.demo.Mapper;

import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    UserService userService;

    @Test
    void userPass() {
        System.out.println(userService.userPassMatching("zhangsan"));

    }
}