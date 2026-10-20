package com.example.demo.Service;

import com.example.demo.model.BookInfo;
import com.example.demo.Dao.BookDao;

import java.util.List;

public class BookService {
    public List<BookInfo> getBookList(){
        BookDao bookDao=new BookDao();
        List<BookInfo> bookInfoList = bookDao.treatData();

        for(BookInfo bookInfo:bookInfoList){
            if(bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }

        return bookInfoList;
    }
}
