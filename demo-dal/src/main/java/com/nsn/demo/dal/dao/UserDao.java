package com.nsn.demo.dal.dao;

import com.nsn.demo.dal.mapper.UserMapper;
import com.nsn.demo.dal.po.User;

/**
 * 自定义操作数据库接口 继承UserMapper  UserMapper  可以重复生成自由覆盖
 *
 * @author donghao
 */
public interface UserDao extends UserMapper {

    /**
     * limit 1  例子
     * @return
     */
    User selectOne();
}
