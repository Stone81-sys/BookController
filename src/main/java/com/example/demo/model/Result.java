package com.example.demo.model;

import com.example.demo.enums.ResultStates;
import lombok.Data;

@Data
public class Result<T> {

    ResultStates states;//1.正确无事发生
    String message;
    T data;

    public Result(ResultStates states, String message, T data) {
        this.states = states;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data){

        Result<T> result=new Result<>(ResultStates.SUCCESS,"",data);
        return result;
    }

    public static <T> Result<T> unlogin(){

        Result<T> result=new Result<>(ResultStates.UNLOGIN,"该用户未登录",null);
        return result;
    }

}
