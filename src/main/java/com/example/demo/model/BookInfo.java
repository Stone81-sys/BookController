package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BookInfo {
//    CREATE TABLE `book_info` (
//            `id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
//        `book_name` VARCHAR ( 127 ) NOT NULL,
//        `author` VARCHAR ( 127 ) NOT NULL,
//        `count` INT ( 11 ) NOT NULL,
//        `price` DECIMAL (7,2 ) NOT NULL,
//        `publish` VARCHAR ( 256 ) NOT NULL,
//        `status` TINYINT ( 4 ) DEFAULT 1 COMMENT '0-无效, 1-正常, 2-不允许借阅',
//            `create_time` DATETIME DEFAULT now(),
//        `update_time` DATETIME DEFAULT now() ON UPDATE now(),
//    PRIMARY KEY ( `id` )
//) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

    Integer id;
    String bookName;
    String author;
    Integer count;
    Integer price;
    String publish;
    Integer status;
    String StatusCN;
    LocalDateTime createTime;
    LocalDateTime updateTime;


}

