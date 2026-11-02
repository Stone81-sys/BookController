package com.example.demo.controller;

import com.example.demo.constants.Constants;
import com.example.demo.model.*;
import com.example.demo.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@ResponseBody
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;


    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        if(!StringUtils.hasLength(bookInfo.getBookName())
                ||!StringUtils.hasLength(bookInfo.getAuthor())
                ||!StringUtils.hasLength(bookInfo.getPublish())
                ||bookInfo.getCount()==0
                ||bookInfo.getPrice()==0
                ||bookInfo.getStatus()==0

        ){
            return "输入不合规 , 请重新输入";
        }
        try{
            bookService.addBook(bookInfo);
            return "";

        }catch (Exception e){
            log.error("添加失败",e);
            return e.getMessage();
        }
    }

    @RequestMapping("/getList")
    public Result<PageResult> getList(PageRequest pageRequest, HttpSession session){

        if(session.getAttribute(Constants.USER_KEY)==null){
            return Result.unlogin();
        }

        UserInfo userInfo=(UserInfo) session.getAttribute(Constants.USER_KEY);

        if(userInfo==null){
            return Result.unlogin();
        }

        PageResult<BookInfo> pageResult =
                bookService.bookCurrentList(pageRequest);

        return Result.success(pageResult);
    }

    @RequestMapping("/updateBook")
    public String UpdateBook(BookInfo bookInfo){
        //TODO 什么都没改会怎么样
        try {
            if (bookService.updateBookInfo(bookInfo) > 0) {
                return "";
            }
        }catch (Exception e){
            e.getMessage();
        }
        return "更新失败";
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId){

        if(bookId==null||bookId<=0){
            return new BookInfo();
        }
        return  bookService.selectSomeBook(bookId);
    }
//RequestParam 一定要加原因 还有把它加到GitHub上面
    @RequestMapping("/batchDeleteBook")
    public Boolean batchDeleteBook(@RequestParam List<Integer> ids){
        try {
            bookService.batchDeleteBook(ids);
        }catch (Exception e){
            e.getMessage();
            return false;
        }
        return true;

    }



}
