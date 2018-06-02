package com.nsn.demo.web.vo;

import com.nsn.demo.web.enumeration.ResponseEnum;

public class BasicResponse<T> {

    private String code;

    private String message;

    private T data;

    public BasicResponse(T data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
        this.data = data;
    }

    public BasicResponse(T data, String code, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
