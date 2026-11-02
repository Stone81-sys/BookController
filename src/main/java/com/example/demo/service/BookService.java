package com.example.demo.service;

import com.example.demo.enums.BookStatus;
import com.example.demo.mapper.BookInfoMapper;
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

        return bookInfoMapper.selectAllBook();
    }

    public PageResult<BookInfo> bookCurrentList(PageRequest pageRequest){

        int bookTotal=bookInfoMapper.selectTotal();

        List<BookInfo> bookListCurrent=bookInfoMapper.selectCurrentBook(pageRequest);

        for(BookInfo bookInfo:bookListCurrent) {

            bookInfo.setStatusCN(BookStatus.getName(bookInfo.getStatus()));
        }

        return new PageResult(bookListCurrent,bookTotal,pageRequest);
    }

    public int updateBookInfo(BookInfo bookInfo){

        return bookInfoMapper.updateBookInfo(bookInfo);
    }

    public BookInfo selectSomeBook(int id){
        return bookInfoMapper.selectSomeBook(id);
    }

    public int batchDeleteBook(List<Integer> ids) {

        int affectLine=0;
        affectLine+=bookInfoMapper.updateBookById(ids);

        return affectLine;
    }
}
