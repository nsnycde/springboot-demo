package com.nsn.demo.service.bo;

import lombok.Data;

/**
 * @author nsn
 *  业务不复杂情况下 service和web共用VO  dao层用po
 */

@Data
public class UserBO {

    private Integer userId;
    private String userName;
    private String password;
    private String phone;

}
