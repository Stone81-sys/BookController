package com.example.demo.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Data
public class BookInfo {
    int id;
    String bookName;
    String author;
    int count;
    BigDecimal price;
    String publish;
    int status;
    String statusCN;

}
