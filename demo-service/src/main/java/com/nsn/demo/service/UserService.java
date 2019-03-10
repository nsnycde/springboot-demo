package com.nsn.demo.service;

import com.nsn.demo.dal.po.User;
import com.nsn.demo.service.bo.UserBO;

public interface UserService {


    User selectOne();

    int deleteByPrimaryKey(Integer userId);

    int insert(UserBO record);

    int insertSelective(UserBO record);

    UserBO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserBO record);

    int updateByPrimaryKey(UserBO record);
}
