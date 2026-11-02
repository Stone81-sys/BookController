package com.example.demo.enums;

public enum ResultStates {
    SUCCESS(1,"执行成功"),
    UNLOGIN(-1,"登陆失败")
    ;

    private int code;
    private String name;

    ResultStates(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public int getCode(){
        return code;
    }
}
