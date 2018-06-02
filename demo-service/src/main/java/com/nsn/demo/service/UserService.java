package com.nsn.demo.service;

import com.nsn.demo.service.bo.UserBO;

public interface UserService {

    int deleteByPrimaryKey(Integer userId);

    int insert(UserBO record);

    int insertSelective(UserBO record);

    UserBO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserBO record);

    int updateByPrimaryKey(UserBO record);
}
