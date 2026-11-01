package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data

public class PageResult<T> {
    List<T> records;  //所查到的数据列表
    int total; //总记录数,告诉前端显示多少页
    PageRequest pageRequest;

    public PageResult(List<T> records, int total,PageRequest pageRequest) {
        this.records = records;
        this.total = total;
        this.pageRequest = pageRequest;

    }


}
