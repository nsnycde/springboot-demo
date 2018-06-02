package com.nsn.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.nsn.demo.web.enumeration.ResponseEnum;
import com.nsn.demo.web.vo.BasicResponse;
import com.nsn.demo.web.vo.response.UserResponseVO;
import com.nsn.demo.service.UserService;
import com.nsn.demo.service.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "getUser",method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse<UserResponseVO> getUserById(Integer id){
        LOG.info("查询用户id:{}", id);
        try {
            UserBO userBO = userService.selectByPrimaryKey(id);
            UserResponseVO responseVO = new UserResponseVO();
            BeanUtils.copyProperties(userBO, responseVO);
            LOG.info("查询用户出参:{}", JSON.toJSONString(responseVO));
            return new BasicResponse<UserResponseVO>(responseVO);
        } catch (BeansException e) {
            return new BasicResponse<UserResponseVO>(null, ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMessage());
        }
    }
}
