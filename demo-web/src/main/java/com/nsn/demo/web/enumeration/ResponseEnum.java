package com.nsn.demo.web.enumeration;

public enum ResponseEnum {

    SUCCESS("000000", "success"),
    FAIL("999999", "fail"),
    ;

    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
