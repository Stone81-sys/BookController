package com.example.demo.Service;

import com.example.demo.Mapper.BookInfoMapper;
import com.example.demo.model.BookInfo;
import com.example.demo.model.PageRequest;
import com.example.demo.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {

   @Autowired
    BookInfoMapper bookInfoMapper;

    public int addBook(BookInfo bookInfo){

        return  bookInfoMapper.insertBook(bookInfo);
    }

    public List<BookInfo> checkAllBook(){

        return bookInfoMapper.selectBook();
    }

    public PageResult<BookInfo> BookCurrentList(PageRequest pageRequest){

        int bookTotal=bookInfoMapper.selectTotal();



        List<BookInfo> bookListCurrent=bookInfoMapper.selectCurrentBook(pageRequest);

        for(BookInfo bookInfo:bookListCurrent) {

            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            }
            if (bookInfo.getStatus() == 2) {
                bookInfo.setStatusCN("不可借阅");
            }

            if (bookInfo.getStatus() == 0) {
                bookInfo.setStatusCN("无效");
            }
        }
        return new PageResult(bookListCurrent,bookTotal,pageRequest);



    }
}
