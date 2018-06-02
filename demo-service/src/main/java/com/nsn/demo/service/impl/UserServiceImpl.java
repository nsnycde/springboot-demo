package com.nsn.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.nsn.demo.dal.mapper.UserMapper;
import com.nsn.demo.dal.po.User;
import com.nsn.demo.service.UserService;
import com.nsn.demo.service.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Transactional
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Transactional
    public int insert(UserBO record) {
        LOG.info("添加用户入参: {}", JSON.toJSONString(record));
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userMapper.insert(user);
    }

    @Transactional
    public int insertSelective(UserBO record) {
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userMapper.insertSelective(user);
    }

    public UserBO selectByPrimaryKey(Integer userId) {
        LOG.info("查询用户id: {}", userId);
        User user = userMapper.selectByPrimaryKey(userId);
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(user, userBO);
        return userBO;
    }

    @Transactional
    public int updateByPrimaryKeySelective(UserBO record) {
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    public int updateByPrimaryKey(UserBO record) {
        User user = new User();
        BeanUtils.copyProperties(record, user);
        return userMapper.updateByPrimaryKey(user);
    }
}
