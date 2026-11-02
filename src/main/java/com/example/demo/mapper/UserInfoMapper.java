package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("""
        select id,user_name,password,delete_flag,create_time,update_time 
        from user_info where user_name=#{userName}
        """)
        public UserInfo userPassMatching(String userName);

}
