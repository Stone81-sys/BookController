package com.example.demo.Mapper;

import com.example.demo.model.BookInfo;
import com.example.demo.model.PageRequest;
import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface BookInfoMapper {

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

    @Insert(""" 
            insert into book_info
            (`book_name`,`author`,`count`,`price`,`publish`,`status`) 
            values 
            (#{bookName},#{author},#{count},#{price},#{publish},#{status})
            """)
    public int insertBook(BookInfo bookInfo);

    @Select("""
            select `id`,`book_name`,`author`,`count`,`price`,`publish`,`status` 
            from book_info

            """)
    List<BookInfo> selectBook();

    @Select("""
            select count(1) from book_info
            """)
    int selectTotal();

    @Select("""
            select `id`,`book_name`,`author`,`count`,`price`,`publish`,`status`
            from book_info limit #{offset} , #{pageSize}
            """)
    List<BookInfo> selectCurrentBook(PageRequest pageRequest);

}
