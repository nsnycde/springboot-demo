package com.nsn.demo.web.vo.response;

import lombok.Data;

@Data
public class UserResponseVO {

    private Integer userId;
    private String userName;
    private String password;
    private String phone;

}
