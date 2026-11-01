package com.example.demo.model;

import lombok.Data;

@Data
public class UserInfo {
    //    CREATE TABLE user_info (
//        `id` INT NOT NULL AUTO_INCREMENT,
//        `user_name` VARCHAR ( 128 ) NOT NULL,
//        `password` VARCHAR ( 128 ) NOT NULL,
//        `delete_flag` TINYINT ( 4 ) NULL DEFAULT 0,
//            `create_time` DATETIME DEFAULT now(),
//        `update_time` DATETIME DEFAULT now() ON UPDATE now(),
//    PRIMARY KEY ( `id` ),
//    UNIQUE INDEX `user_name_UNIQUE` ( `user_name` ASC )) ENGINE = INNODB DEFAULT CHARACTER
//            SET = utf8mb4 COMMENT = '用户表';
    Integer id;
    String userName;
    String password;
    Integer deleteFlag;
    Data createTime;
    Data updateTime;
}
