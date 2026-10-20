package com.example.demo.Controller;

import com.example.demo.model.BookInfo;
import com.example.demo.Service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> booklist(){
        BookService bookService = new BookService();
        List<BookInfo> booklist=bookService.getBookList();
        return booklist;

    }
}
