package com.example.demo.Dao;

import com.example.demo.model.BookInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookDao {

    public List<BookInfo> treatData() {
        List<BookInfo> bookInfoList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            BookInfo book = new BookInfo();
            book.setBookName("你好" + i);
            book.setId(i);
            book.setAuthor("老王啊");
            book.setCount(new Random().nextInt(100));
            book.setPrice(new BigDecimal(new Random().nextInt(100) + i));
            book.setPublish("那个出版社");
            book.setStatus(i % 2);

            bookInfoList.add(book);

        }

        return bookInfoList;
    }
}
