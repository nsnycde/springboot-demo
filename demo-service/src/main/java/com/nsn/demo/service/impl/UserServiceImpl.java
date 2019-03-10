package com.nsn.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.nsn.demo.dal.dao.UserDao;
import com.nsn.demo.dal.po.User;
import com.nsn.demo.service.UserService;
import com.nsn.demo.service.bo.UserBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Transactional
    public int deleteByPrimaryKey(Integer userId) {
        return userDao.deleteByPrimaryKey(userId);
    }

    @Transactional
    public int insert(UserBO record) {
        log.info("添加用户入参: {}", JSON.toJSONString(record));
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userDao.insert(user);
    }

    @Transactional
    public int insertSelective(UserBO record) {
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userDao.insertSelective(user);
    }

    public UserBO selectByPrimaryKey(Integer userId) {
        log.info("查询用户id: {}", userId);
        User user = userDao.selectByPrimaryKey(userId);
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(user, userBO);
        return userBO;
    }

    @Transactional
    public int updateByPrimaryKeySelective(UserBO record) {
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Transactional
    public int updateByPrimaryKey(UserBO record) {
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userDao.updateByPrimaryKey(user);
    }

    public User selectOne() {
        return userDao.selectOne();
    }
}
