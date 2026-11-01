package com.example.demo.Controller;

import com.example.demo.model.BookInfo;
import com.example.demo.Service.BookService;
import com.example.demo.model.PageRequest;
import com.example.demo.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public PageResult<BookInfo> getList(PageRequest pageRequest){

        PageResult<BookInfo> pageResult=
        bookService.bookCurrentList(pageRequest);

        return pageResult;
    }

    @RequestMapping("/updateBook")
    public String UpdateBook(BookInfo bookInfo){

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

}
