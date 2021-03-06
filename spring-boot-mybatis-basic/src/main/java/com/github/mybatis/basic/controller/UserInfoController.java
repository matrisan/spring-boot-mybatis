package com.github.mybatis.basic.controller;


import com.github.mybatis.basic.repository.IUserInfoMapper;
import com.github.mybatis.common.pojo.UserInfoDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-12-03 14:43
 * @since 1.0
 */

@RestController
public class UserInfoController {

    @Resource
    private IUserInfoMapper mapper;

    @GetMapping("{id}")
    public UserInfoDO findById(@PathVariable long id) {
        return mapper.selectFromUserInfoByUserId(id);
    }


}
