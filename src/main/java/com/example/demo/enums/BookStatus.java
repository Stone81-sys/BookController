package com.example.demo.enums;

public enum BookStatus {
    DELETETE(0,"无效"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅");

    private int code;
    private String name;

    private BookStatus(int code,String name) {
        this.code=code;
        this.name=name;
    }

    public static String getName(int code){
        switch (code){
            case 0:return DELETETE.name;
            case 1:return NORMAL.name;
            case 2:return FORBIDDEN.name;
        }
        return null;
    }

}
