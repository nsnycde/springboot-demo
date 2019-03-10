package com.nsn.demo.web.vo.request;

import lombok.Data;

@Data
public class UserRequestVO {

    private Integer userId;
    private String userName;
    private String password;
    private String phone;

}
