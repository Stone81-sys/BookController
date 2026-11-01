package com.example.demo.model;

import lombok.Data;

@Data
public class PageRequest {
    int currentPage=1; //当前页码
    int pageSize=10; //显示条数
    int offset;

    public int getOffset(){
        this.offset=(currentPage-1)*pageSize;
        return offset;
    }
}
