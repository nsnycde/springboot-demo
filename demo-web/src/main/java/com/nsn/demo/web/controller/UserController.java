package com.nsn.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.nsn.demo.dal.po.User;
import com.nsn.demo.service.UserService;
import com.nsn.demo.service.bo.UserBO;
import com.nsn.demo.web.enumeration.ResponseEnum;
import com.nsn.demo.web.vo.BasicResponse;
import com.nsn.demo.web.vo.response.UserResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author donghao
 */
@Slf4j
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "getUser",method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse<UserResponseVO> getUserById(Integer id){
        log.info("查询用户id:{}", id);
        try {
            UserBO userBO = userService.selectByPrimaryKey(id);
            UserResponseVO responseVO = new UserResponseVO();
            BeanUtils.copyProperties(userBO, responseVO);
            log.info("查询用户出参:{}", JSON.toJSONString(responseVO));
            return new BasicResponse<UserResponseVO>(responseVO);
        } catch (BeansException e) {
            return new BasicResponse<UserResponseVO>(null, ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMessage());
        }
    }

    @RequestMapping(value = "get")
    @ResponseBody
    public BasicResponse<User> getUser(){
        try {
            return new BasicResponse<User>(userService.selectOne());
        } catch (BeansException e) {
            return new BasicResponse<User>(null, ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMessage());
        }
    }
}
