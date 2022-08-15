package com.atguigu.common.Exception;

public enum ExceptionStatusCode {

    SYSTEM_EXCEPTION(1000,"系统未知错误"),
    VALID_EXCEPTION(1001,"数据校验错误");

    private int code;
    private String message;

    ExceptionStatusCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
